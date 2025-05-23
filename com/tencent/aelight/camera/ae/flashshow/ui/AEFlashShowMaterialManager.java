package com.tencent.aelight.camera.ae.flashshow.ui;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.api.IAEPath;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.IAEDownloadMaterial;
import com.tencent.aelight.camera.qqstory.api.IQIMPtvTemplateManager;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.aelight.camera.util.api.IAEMaterialParserUtil;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.collection.QQConcurrentHashMap;
import com.tencent.cache.api.collection.QQCopyOnWriteArrayList;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import feedcloud.TagCollection$ReadListRsp;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u008a\u00012\u00020\u0001:\u0001VB\t\u00a2\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0013\u0010\u000e\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u001b\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\u0012\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u001aH\u0002J\u0012\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u001aH\u0002J\u001a\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0012\u0010!\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\"\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010#\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010$\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\tH\u0002J\"\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u001a2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001dH\u0002J\b\u0010(\u001a\u00020\u0004H\u0002J\b\u0010)\u001a\u00020\u0011H\u0002J,\u00100\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u00010\u00182\b\u0010/\u001a\u0004\u0018\u00010.H\u0002J\u0012\u00102\u001a\u0004\u0018\u00010\u00182\u0006\u00101\u001a\u00020\u0018H\u0002J\b\u00103\u001a\u00020\u0004H\u0016J\b\u00104\u001a\u00020\u0004H\u0016J\u000e\u00105\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u00106\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u00107\u001a\u00020\u0004J\u0010\u00109\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u000108J\u0010\u0010:\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u000108J\u0010\u0010;\u001a\u00020\u00022\b\u00101\u001a\u0004\u0018\u00010\u0018J\u0006\u0010<\u001a\u00020\u0004J\u000e\u0010=\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0018J\u001b\u0010>\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u0018H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b>\u0010?J\u001b\u0010@\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u0018H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b@\u0010?J\u000e\u0010A\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0018J\u0006\u0010B\u001a\u00020\u0004J\u0010\u0010C\u001a\u00020\u00022\b\u00101\u001a\u0004\u0018\u00010\u0018J\u0018\u0010E\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u00182\u0006\u0010D\u001a\u00020\u0002J\u0010\u0010F\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0018\u0010K\u001a\u00020\u00042\b\u0010H\u001a\u0004\u0018\u00010G2\u0006\u0010J\u001a\u00020IJ\u000e\u0010L\u001a\u00020\u00042\u0006\u0010J\u001a\u00020IJ\u0010\u0010N\u001a\u00020\u00042\b\u0010M\u001a\u0004\u0018\u00010GJ\u0014\u0010P\u001a\b\u0012\u0004\u0012\u00020\t0\u001a2\u0006\u0010O\u001a\u00020\u0002J\u0006\u0010Q\u001a\u00020\u0004J\u000e\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001aJ\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\t0\u001aJ$\u0010T\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010*2\b\u0010-\u001a\u0004\u0018\u00010\u00182\b\u0010/\u001a\u0004\u0018\u00010.J.\u0010U\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010*2\b\u0010,\u001a\u0004\u0018\u00010\u00112\b\u0010-\u001a\u0004\u0018\u00010\u00182\b\u0010/\u001a\u0004\u0018\u00010.R\u0016\u0010W\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u00107R\u0016\u0010Y\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u00107R\u0014\u0010]\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010_\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010\\R\u0014\u0010a\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010\\R \u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00180b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u001a\u0010i\u001a\b\u0012\u0004\u0012\u00020\t0f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u001a\u0010m\u001a\b\u0012\u0004\u0012\u00020\t0j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u001a\u0010o\u001a\b\u0012\u0004\u0012\u00020\t0j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010lR\u001d\u0010s\u001a\b\u0012\u0004\u0012\u00020\t0j8\u0006\u00a2\u0006\f\n\u0004\bp\u0010l\u001a\u0004\bq\u0010rR\u0014\u0010v\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010z\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010yR$\u0010\u0081\u0001\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R(\u0010\u0087\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0082\u0001\u00107\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u008b\u0001"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialManager;", "Lcom/tencent/aelight/camera/ae/control/b;", "", "forceRefresh", "", "H", "", "start", "W", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialCategory;", "category", ReportConstant.COSTREPORT_PREFIX, "V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "favoriteCategory", "", "key", "i0", "needClearList", HippyTKDListViewAdapter.X, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "id", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "D", "", "a0", ExifInterface.LATITUDE_SOUTH, "Ljava/io/File;", "cacheFile", "T", "cat", "J", "L", "N", "M", "oldJsonFile", "newJsonFile", "P", "g0", "w", "Lmqq/app/AppRuntime;", "app", "downloadDir", "data", "Lcom/tencent/aelight/camera/download/a;", "listener", "q0", "info", "u", "onInit", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "I", UserInfo.SEX_FEMALE, "Z", "Lcom/tencent/ttpic/openapi/model/VideoMaterial;", "Y", "X", "O", "h0", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "(Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f0", "e0", "b0", "K", "addToRecent", "m0", "l0", "Lyq2/c;", "adapterObserver", "", "eventId", "p", "c0", "observer", "d0", "loadFavorite", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "t", "y", "v", "r0", "o0", "a", "mUseFlashShowMaterial", "b", "mHasLoaded", "", "c", "Ljava/lang/Object;", "mFavoriteListLock", "d", "mMaterialMapLock", "e", "mFileAccessLock", "Lcom/tencent/cache/api/collection/QQConcurrentHashMap;", "f", "Lcom/tencent/cache/api/collection/QQConcurrentHashMap;", "mAEMaterialMap", "Lcom/tencent/cache/api/collection/QQCopyOnWriteArrayList;", "g", "Lcom/tencent/cache/api/collection/QQCopyOnWriteArrayList;", "mStickerMaterialList", "Ljava/util/ArrayList;", tl.h.F, "Ljava/util/ArrayList;", "mCosmeticMaterialList", "i", "mFilterList", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Ljava/util/ArrayList;", "mGuidePicList", "k", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialCategory;", "mFavoriteCategory", "Lyq2/b;", "l", "Lyq2/b;", "mPtvTemplateObservable", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", BdhLogUtil.LogTag.Tag_Conn, "()Ljava/lang/String;", "n0", "(Ljava/lang/String;)V", "selectedMaterialId", DomainData.DOMAIN_NAME, "getOnlyReloadFavoriteList", "()Z", "k0", "(Z)V", "onlyReloadFavoriteList", "<init>", "()V", "o", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AEFlashShowMaterialManager extends com.tencent.aelight.camera.ae.control.b {

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: p, reason: collision with root package name */
    private static AEMaterialMetaData f64550p;

    /* renamed from: q, reason: collision with root package name */
    private static AEMaterialCategory f64551q;

    /* renamed from: r, reason: collision with root package name */
    private static volatile boolean f64552r;

    /* renamed from: s, reason: collision with root package name */
    private static volatile boolean f64553s;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mHasLoaded;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final QQConcurrentHashMap<String, AEMaterialMetaData> mAEMaterialMap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final QQCopyOnWriteArrayList<AEMaterialCategory> mStickerMaterialList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<AEMaterialCategory> mCosmeticMaterialList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<AEMaterialCategory> mFilterList;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<AEMaterialCategory> mGuidePicList;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final AEMaterialCategory mFavoriteCategory;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private yq2.b mPtvTemplateObservable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String selectedMaterialId;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean onlyReloadFavoriteList;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean mUseFlashShowMaterial = true;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Object mFavoriteListLock = new Object();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Object mMaterialMapLock = new Object();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Object mFileAccessLock = new Object();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007R\"\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0013R\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u0014\u0010\u001e\u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0017R\u0014\u0010\u001f\u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0014\u0010 \u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u0017R\u0014\u0010!\u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0017R\u0014\u0010\"\u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0017R\u0014\u0010#\u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0017R\u0014\u0010$\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0013R\u0014\u0010%\u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0017R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006-"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialManager$a;", "", "", "d", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "c", "data", "", "e", "sIsCapturing", "Z", "b", "()Z", "g", "(Z)V", "sIsCameraResume", "a", "f", "AE_CAMERA_UPDATE_PENDING_JSON", "Ljava/lang/String;", "AE_FLASH_SHOW_UPDATE_PENDING_JSON", "", "COSMETIC_CATEGORY_ID", "I", "DOWNLOAD_TEMPLATE_SUCCESS_UPDATE", "FILTER_CATEGORY_ID", "GUILD_PIC_CATEGORY_ID", "HIDE_WATERMARK_EDITPICTURE", "RECENT_TEMPLATE_CAMERA_LIST", "RECENT_TEMPLATE_FLASH_SHOW_LIST", "RECENT_TEMPLATE_UPDATE", "SELECT_TEMPLATE_UPDATE", "SELECT_WATERMARK_AUTO", "SELECT_WATERMARK_USER", "SHOW_WATERMARK_EDITPICTURE", "SICKER_MATERIAL_CATEGORY_ID", "TAG", "TEMPLATE_INFO_LIST_UPDATE", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialCategory;", "selectedCategory", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialCategory;", "sessionSelectedMaterial", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return AEFlashShowMaterialManager.f64553s;
        }

        public final boolean b() {
            return AEFlashShowMaterialManager.f64552r;
        }

        @JvmStatic
        public final AEMaterialMetaData c() {
            return AEFlashShowMaterialManager.f64550p;
        }

        @JvmStatic
        public final String d() {
            File file = new File(((IAEPath) QRoute.api(IAEPath.class)).getCameraMaterialConfig());
            if (!file.exists()) {
                file.mkdirs();
            }
            String path = new File(file.getPath(), "camera_flash_show_update_template.json").getPath();
            Intrinsics.checkNotNullExpressionValue(path, "File(dir.path, AE_FLASH_\u2026UPDATE_PENDING_JSON).path");
            return path;
        }

        public final void f(boolean z16) {
            AEFlashShowMaterialManager.f64553s = z16;
        }

        public final void g(boolean z16) {
            AEFlashShowMaterialManager.f64552r = z16;
        }

        Companion() {
        }

        @JvmStatic
        public final boolean e(AEMaterialMetaData data) {
            if (data == null) {
                return true;
            }
            ArrayList<String> arrayList = data.mask;
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList<String> arrayList2 = data.mask;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "data.mask");
                for (String str : arrayList2) {
                    if (Intrinsics.areEqual(str, "qzone")) {
                        if (Intrinsics.areEqual(WinkContext.INSTANCE.d().k().a(), "QZONE")) {
                            ms.a.f("AEFlashShowMaterialManager", "need hide in qzone");
                            return true;
                        }
                    } else if (Intrinsics.areEqual(str, "qcircle") && Intrinsics.areEqual(WinkContext.INSTANCE.d().k().a(), "QCIRCLE")) {
                        ms.a.f("AEFlashShowMaterialManager", "need hide in qcircle");
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\n\u00a2\u0006\u0002\b\f"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "success", "", "code", "", "message", "", "o", "", "onReceive"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes32.dex */
    static final class b<T> implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f64568a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super Boolean> continuation) {
            this.f64568a = continuation;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String message, Object obj) {
            Intrinsics.checkNotNullParameter(message, "message");
            if (z16 && j3 == 0) {
                Continuation<Boolean> continuation = this.f64568a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
            } else {
                Continuation<Boolean> continuation2 = this.f64568a;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u000b\u001a\u00020\n2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/biz/richframework/network/request/BaseRequest;", "<anonymous parameter 0>", "", "isSuccess", "", "retCode", "", "errMsg", "Lfeedcloud/TagCollection$ReadListRsp;", "rsp", "", "a", "(Lcom/tencent/biz/richframework/network/request/BaseRequest;ZJLjava/lang/String;Lfeedcloud/TagCollection$ReadListRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class c<T> implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f64570b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f64571c;

        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super Boolean> continuation, boolean z16) {
            this.f64570b = continuation;
            this.f64571c = z16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String errMsg, TagCollection$ReadListRsp tagCollection$ReadListRsp) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.d("AEFlashShowMaterialManager", 1, "[getFavoriteListFromServer] success:" + z16 + " retCode:" + j3 + " errMsg:" + errMsg);
            if (z16 && j3 == 0 && tagCollection$ReadListRsp != null) {
                Object obj = AEFlashShowMaterialManager.this.mFavoriteListLock;
                boolean z17 = this.f64571c;
                AEFlashShowMaterialManager aEFlashShowMaterialManager = AEFlashShowMaterialManager.this;
                synchronized (obj) {
                    List<String> ids = tagCollection$ReadListRsp.unified_id.get();
                    QLog.d("AEFlashShowMaterialManager", 1, "[getFavoriteListFromServer] ids:" + ids + " needClearList:" + z17);
                    if (z17) {
                        aEFlashShowMaterialManager.mFavoriteCategory.f69044d.clear();
                    }
                    Intrinsics.checkNotNullExpressionValue(ids, "ids");
                    for (String id5 : ids) {
                        Intrinsics.checkNotNullExpressionValue(id5, "id");
                        AEMaterialMetaData D = aEFlashShowMaterialManager.D(id5);
                        if (!aEFlashShowMaterialManager.mFavoriteCategory.f69044d.contains(D)) {
                            if (!Intrinsics.areEqual(D != null ? D.f69050id : null, "0")) {
                                if (D == null) {
                                    QLog.w("AEFlashShowMaterialManager", 1, "info is null id:" + id5);
                                } else {
                                    aEFlashShowMaterialManager.mFavoriteCategory.f69044d.add(D);
                                }
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            Continuation<Boolean> continuation = this.f64570b;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\n\u00a2\u0006\u0002\b\f"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "success", "", "code", "", "message", "", "o", "", "onReceive"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes32.dex */
    static final class d<T> implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f64572a;

        /* JADX WARN: Multi-variable type inference failed */
        d(Continuation<? super Boolean> continuation) {
            this.f64572a = continuation;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String message, Object obj) {
            Intrinsics.checkNotNullParameter(message, "message");
            if (z16 && j3 == 0) {
                Continuation<Boolean> continuation = this.f64572a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
            } else {
                Continuation<Boolean> continuation2 = this.f64572a;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialManager$e", "Lcom/tencent/aelight/camera/download/a;", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "info", "", "isSuccess", "", "resCode", "", "onDownloadFinish", "progress", "onProgressUpdate", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class e implements com.tencent.aelight.camera.download.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.aelight.camera.download.a f64574e;

        e(com.tencent.aelight.camera.download.a aVar) {
            this.f64574e = aVar;
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onDownloadFinish(AEMaterialMetaData info, boolean isSuccess, int resCode) {
            Intrinsics.checkNotNullParameter(info, "info");
            AEMaterialMetaData u16 = AEFlashShowMaterialManager.this.u(info);
            if (u16 != null) {
                u16.usable = AEFlashShowMaterialManager.this.O(info);
            }
            com.tencent.aelight.camera.download.a aVar = this.f64574e;
            if (aVar != null) {
                aVar.onDownloadFinish(info, isSuccess, resCode);
            }
            ms.a.f("AEFlashShowMaterialManager", "\u3010END\u3011onDownloadFinish :" + (u16 != null ? u16.f69050id : null));
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onProgressUpdate(AEMaterialMetaData info, int progress) {
            Intrinsics.checkNotNullParameter(info, "info");
            com.tencent.aelight.camera.download.a aVar = this.f64574e;
            if (aVar != null) {
                aVar.onProgressUpdate(info, progress);
            }
        }
    }

    public AEFlashShowMaterialManager() {
        Business business = Business.QCircle;
        this.mAEMaterialMap = new QQConcurrentHashMap<>(business, "AEFlashShowMaterialManager");
        this.mStickerMaterialList = new QQCopyOnWriteArrayList<>(business, "AEFlashShowMaterialManager");
        this.mCosmeticMaterialList = new ArrayList<>();
        this.mFilterList = new ArrayList<>();
        this.mGuidePicList = new ArrayList<>();
        this.selectedMaterialId = "";
        AEMaterialCategory aEMaterialCategory = new AEMaterialCategory(w());
        aEMaterialCategory.f69044d = new LinkedList();
        this.mFavoriteCategory = aEMaterialCategory;
    }

    @JvmStatic
    public static final AEMaterialMetaData B() {
        return INSTANCE.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AEMaterialMetaData D(String id5) {
        synchronized (this.mMaterialMapLock) {
            Iterator<AEMaterialCategory> it = this.mStickerMaterialList.iterator();
            while (it.hasNext()) {
                for (AEMaterialMetaData aEMaterialMetaData : it.next().f69044d) {
                    if (Intrinsics.areEqual(aEMaterialMetaData.f69050id, id5)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("AEFlashShowMaterialManager", 2, "getNormalStickerMaterial---found id=" + id5);
                        }
                        return aEMaterialMetaData;
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            return null;
        }
    }

    @JvmStatic
    public static final String E() {
        return INSTANCE.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(AEFlashShowMaterialManager this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H(z16);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00e2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00e3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d2 A[Catch: all -> 0x016e, TryCatch #2 {, blocks: (B:37:0x0099, B:38:0x00b1, B:40:0x00b7, B:43:0x00c0, B:45:0x00c6, B:50:0x00d2, B:52:0x00d6, B:58:0x00e3, B:59:0x00f4, B:61:0x00fa, B:64:0x0102, B:67:0x010a, B:73:0x0112, B:101:0x0118, B:76:0x011e, B:98:0x0124, B:79:0x012a, B:95:0x0130, B:82:0x0137, B:85:0x013d, B:86:0x0153, B:88:0x0159, B:90:0x0163, B:113:0x016a), top: B:36:0x0099 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fa A[Catch: all -> 0x016e, TryCatch #2 {, blocks: (B:37:0x0099, B:38:0x00b1, B:40:0x00b7, B:43:0x00c0, B:45:0x00c6, B:50:0x00d2, B:52:0x00d6, B:58:0x00e3, B:59:0x00f4, B:61:0x00fa, B:64:0x0102, B:67:0x010a, B:73:0x0112, B:101:0x0118, B:76:0x011e, B:98:0x0124, B:79:0x012a, B:95:0x0130, B:82:0x0137, B:85:0x013d, B:86:0x0153, B:88:0x0159, B:90:0x0163, B:113:0x016a), top: B:36:0x0099 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x011e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void H(boolean forceRefresh) {
        List<AEMaterialCategory> a06;
        boolean z16;
        boolean z17;
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            ms.a.a("AEFlashShowMaterialManager", "initMaterialList enter---forceRefresh=" + forceRefresh);
        }
        synchronized (this) {
            if (this.mHasLoaded && !forceRefresh) {
                ms.a.f("AEFlashShowMaterialManager", "initMaterialList---has inited, fast return onlyReloadFavoriteList:" + this.onlyReloadFavoriteList);
                if (this.onlyReloadFavoriteList && o83.a.f422212a.d()) {
                    this.onlyReloadFavoriteList = false;
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AEFlashShowMaterialManager$initMaterialList$1$1(this, currentTimeMillis, null), 3, null);
                }
                return;
            }
            this.mHasLoaded = true;
            this.onlyReloadFavoriteList = false;
            Unit unit = Unit.INSTANCE;
            synchronized (this.mFileAccessLock) {
                a06 = a0();
            }
            List<AEMaterialCategory> list = a06;
            if (list == null || list.isEmpty()) {
                ms.a.c("AEFlashShowMaterialManager", "initMaterialList: materials is empty !");
                return;
            }
            if (a06 != null) {
                synchronized (this.mMaterialMapLock) {
                    this.mAEMaterialMap.clear();
                    this.mStickerMaterialList.clear();
                    this.mCosmeticMaterialList.clear();
                    this.mFilterList.clear();
                    for (AEMaterialCategory aEMaterialCategory : a06) {
                        if (aEMaterialCategory != null) {
                            List<AEMaterialMetaData> list2 = aEMaterialCategory.f69044d;
                            if (list2 != null && !list2.isEmpty()) {
                                z16 = false;
                                if (z16) {
                                    ArrayList<MetaCategory> arrayList = aEMaterialCategory.D;
                                    if (arrayList != null && !arrayList.isEmpty()) {
                                        z17 = false;
                                        if (!z17) {
                                        }
                                    }
                                    z17 = true;
                                    if (!z17) {
                                    }
                                }
                                s(aEMaterialCategory);
                                List<AEMaterialMetaData> list3 = aEMaterialCategory.f69044d;
                                Intrinsics.checkNotNullExpressionValue(list3, "item.materialList");
                                for (AEMaterialMetaData aEMaterialMetaData : list3) {
                                    if (aEMaterialMetaData != null && !TextUtils.isEmpty(aEMaterialMetaData.f69050id)) {
                                        this.mAEMaterialMap.put(aEMaterialMetaData.f69050id, aEMaterialMetaData);
                                    }
                                }
                                if (!L(aEMaterialCategory)) {
                                    this.mFilterList.add(aEMaterialCategory);
                                } else if (J(aEMaterialCategory)) {
                                    this.mCosmeticMaterialList.add(aEMaterialCategory);
                                } else if (M(aEMaterialCategory)) {
                                    this.mGuidePicList.add(aEMaterialCategory);
                                } else if (N(aEMaterialCategory)) {
                                    ArrayList arrayList2 = new ArrayList();
                                    ((IAEMaterialParserUtil) QRoute.api(IAEMaterialParserUtil.class)).parseCategory(aEMaterialCategory.D, arrayList2);
                                    Iterator it = arrayList2.iterator();
                                    while (it.hasNext()) {
                                        s((AEMaterialCategory) it.next());
                                    }
                                    this.mStickerMaterialList.addAll(arrayList2);
                                }
                            }
                            z16 = true;
                            if (z16) {
                            }
                            s(aEMaterialCategory);
                            List<AEMaterialMetaData> list32 = aEMaterialCategory.f69044d;
                            Intrinsics.checkNotNullExpressionValue(list32, "item.materialList");
                            while (r7.hasNext()) {
                            }
                            if (!L(aEMaterialCategory)) {
                            }
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            if (o83.a.f422212a.d()) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AEFlashShowMaterialManager$initMaterialList$4(this, currentTimeMillis, null), 3, null);
            } else {
                Q();
                W(currentTimeMillis);
            }
        }
    }

    private final List<AEMaterialCategory> P(File oldJsonFile, File newJsonFile) throws Exception {
        AEMaterialCategory aEMaterialCategory;
        AEMaterialMetaData aEMaterialMetaData;
        List<AEMaterialCategory> T = T(oldJsonFile);
        List<AEMaterialCategory> T2 = T(newJsonFile);
        if (T2 == null || T2.isEmpty()) {
            return T;
        }
        Intrinsics.checkNotNull(T);
        for (AEMaterialCategory aEMaterialCategory2 : T) {
            Iterator<AEMaterialCategory> it = T2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aEMaterialCategory = null;
                    break;
                }
                aEMaterialCategory = it.next();
                Intrinsics.checkNotNull(aEMaterialCategory);
                String str = aEMaterialCategory.f69047h;
                Intrinsics.checkNotNull(aEMaterialCategory2);
                if (Intrinsics.areEqual(str, aEMaterialCategory2.f69047h)) {
                    break;
                }
            }
            if (aEMaterialCategory == null) {
                Intrinsics.checkNotNull(aEMaterialCategory2);
                Iterator<AEMaterialMetaData> it5 = aEMaterialCategory2.f69044d.iterator();
                while (it5.hasNext()) {
                    it5.next().deleteAllOldFile();
                }
            } else {
                Intrinsics.checkNotNull(aEMaterialCategory2);
                for (AEMaterialMetaData aEMaterialMetaData2 : aEMaterialCategory2.f69044d) {
                    Iterator<AEMaterialMetaData> it6 = aEMaterialCategory.f69044d.iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            aEMaterialMetaData = null;
                            break;
                        }
                        aEMaterialMetaData = it6.next();
                        if (Intrinsics.areEqual(aEMaterialMetaData2.f69050id, aEMaterialMetaData.f69050id)) {
                            break;
                        }
                    }
                    if (aEMaterialMetaData == null) {
                        aEMaterialMetaData2.deleteAllOldFile();
                    } else if (!Intrinsics.areEqual(aEMaterialMetaData2.md5, aEMaterialMetaData.md5)) {
                        aEMaterialMetaData2.deleteAllOldFile();
                    }
                }
            }
        }
        return T2;
    }

    private final void Q() {
        String str;
        AEMaterialCategory aEMaterialCategory = this.mFavoriteCategory;
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        if (this.mUseFlashShowMaterial) {
            str = "recent_template_flash_show_list";
        } else {
            str = "recent_template_list_new";
        }
        String j3 = AECameraPrefsUtil.f().j(str + account, null, 0);
        if (QLog.isColorLevel()) {
            QLog.d("AEFlashShowMaterialManager", 2, "loadFavoriteMaterials list=" + j3);
        }
        if (j3 == null) {
            return;
        }
        Object[] array = new Regex("\\$").split(j3, 0).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        synchronized (this.mFavoriteListLock) {
            List<AEMaterialMetaData> list = aEMaterialCategory.f69044d;
            if (list != null) {
                list.clear();
            }
            for (String str2 : strArr) {
                Object[] array2 = new Regex("\\|").split(str2, 0).toArray(new String[0]);
                Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                if (array2.length == 2) {
                    String str3 = ((String[]) array2)[0];
                    AEMaterialMetaData D = str3 != null ? D(str3) : null;
                    if (!aEMaterialCategory.f69044d.contains(D)) {
                        if (!Intrinsics.areEqual(D != null ? D.f69050id : null, "0") && D != null) {
                            aEMaterialCategory.f69044d.add(D);
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final List<AEMaterialCategory> S() {
        ArrayList arrayList = new ArrayList();
        String a16 = com.tencent.aelight.camera.ae.config.b.a(getApp().getApp());
        if (TextUtils.isEmpty(a16)) {
            return arrayList;
        }
        try {
            ArrayList<AEMaterialCategory> parseMaterialListFromConfig = ((IAEMaterialParserUtil) QRoute.api(IAEMaterialParserUtil.class)).parseMaterialListFromConfig(a16);
            Intrinsics.checkNotNullExpressionValue(parseMaterialListFromConfig, "{\n            QRoute.api\u2026Config(content)\n        }");
            return parseMaterialListFromConfig.isEmpty() ? arrayList : parseMaterialListFromConfig;
        } catch (Exception e16) {
            QLog.d("AEFlashShowMaterialManager", 4, "loadMaterialListFromAssets err=" + e16.getMessage());
            return arrayList;
        }
    }

    private final List<AEMaterialCategory> T(File cacheFile) throws Exception {
        ArrayList<AEMaterialCategory> parseMaterialListFromConfig;
        ArrayList arrayList = new ArrayList();
        String loadFileContent = ((IQIMPtvTemplateManager) QRoute.api(IQIMPtvTemplateManager.class)).loadFileContent(cacheFile);
        return (TextUtils.isEmpty(loadFileContent) || (parseMaterialListFromConfig = ((IAEMaterialParserUtil) QRoute.api(IAEMaterialParserUtil.class)).parseMaterialListFromConfig(loadFileContent)) == null || parseMaterialListFromConfig.isEmpty()) ? arrayList : parseMaterialListFromConfig;
    }

    @JvmStatic
    public static final boolean U(AEMaterialMetaData aEMaterialMetaData) {
        return INSTANCE.e(aEMaterialMetaData);
    }

    private final void V() {
        AppInterface app = getApp();
        if (app != null) {
            app.notifyObservers(kq.a.class, 3, true, null);
        }
        yq2.b bVar = this.mPtvTemplateObservable;
        if (bVar != null) {
            bVar.c(116, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(long start) {
        QLog.i("AEFlashShowMaterialManager", 2, "notifyUpdated...");
        synchronized (this.mMaterialMapLock) {
            if (this.mStickerMaterialList.size() > 0 && !Intrinsics.areEqual(w(), this.mStickerMaterialList.get(0).f69047h)) {
                this.mStickerMaterialList.add(0, this.mFavoriteCategory);
            }
            Unit unit = Unit.INSTANCE;
        }
        if (QLog.isColorLevel()) {
            long currentTimeMillis = System.currentTimeMillis();
            QLog.d("AEFlashShowMaterialManager", 2, "initMaterialList, mStickerMaterialList.size = " + this.mStickerMaterialList.size());
            QLog.d("AEFlashShowMaterialManager", 2, "initMaterialList exit, cost = " + (currentTimeMillis - start) + "ms");
        }
        if (this.mStickerMaterialList.size() > 0) {
            AEFlashShowBottomPanelViewModel.INSTANCE.b().postValue(Boolean.TRUE);
        }
        V();
    }

    private final List<AEMaterialCategory> a0() {
        String str;
        List<AEMaterialCategory> S;
        List<AEMaterialCategory> T;
        if (this.mUseFlashShowMaterial) {
            str = "camera_flash_show_update_template.json";
        } else {
            str = "camera_story_update_template.json";
        }
        File file = new File(((IAEPath) QRoute.api(IAEPath.class)).getCameraMaterialConfig(), str);
        File file2 = new File(((IAEPath) QRoute.api(IAEPath.class)).getCameraMaterialConfig(), AECameraConstants.CAMERA_FLASH_SHOW_DEFAULT_JSON);
        if (!file.exists()) {
            if (!file2.exists()) {
                List<AEMaterialCategory> S2 = S();
                ms.a.a("AEFlashShowMaterialManager", "readAndParseConfigFile -> oldJson not exist, newJson not exist, use Json from assets ");
                g0();
                return S2;
            }
            try {
                S = T(file2);
                ms.a.a("AEFlashShowMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, use oldJson");
            } catch (Exception e16) {
                FileUtils.deleteFile(file2.getPath());
                List<AEMaterialCategory> S3 = S();
                ms.a.c("AEFlashShowMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, exception:" + e16);
                g0();
                return S3;
            }
        } else {
            if (!file2.exists()) {
                try {
                    T = T(file);
                    FileUtils.moveFile(file.getPath(), file2.getPath());
                    ms.a.a("AEFlashShowMaterialManager", "readAndParseConfigFile -> oldJson not exist, use newJson ");
                } catch (Exception e17) {
                    FileUtils.deleteFile(file.getPath());
                    S = S();
                    ms.a.c("AEFlashShowMaterialManager", "readAndParseConfigFile -> oldJson not exists: exception:" + e17);
                    g0();
                }
            } else {
                try {
                    T = P(file2, file);
                    FileUtils.deleteFile(file2.getPath());
                    FileUtils.moveFile(file.getPath(), file2.getPath());
                    ms.a.a("AEFlashShowMaterialManager", "readAndParseConfigFile -> try check update ");
                } catch (Exception e18) {
                    S = S();
                    ms.a.c("AEFlashShowMaterialManager", "loadMaterialListFromAssets  -> oldJson exists: exception:" + e18);
                    g0();
                }
            }
            return T;
        }
        return S;
    }

    private final void g0() {
        AECameraPrefsUtil.f().q(IAECameraPrefsUtil.KEY_ETAG_FLASH_SHOW, 4);
        synchronized (this) {
            this.mHasLoaded = false;
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void i0(AEMaterialCategory favoriteCategory, final String key) {
        int collectionSizeOrDefault;
        o83.a aVar = o83.a.f422212a;
        List<AEMaterialMetaData> list = favoriteCategory.f69044d;
        Intrinsics.checkNotNullExpressionValue(list, "favoriteCategory.materialList");
        List<AEMaterialMetaData> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((AEMaterialMetaData) it.next()).f69050id);
        }
        aVar.e("meterial", arrayList, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.bk
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                AEFlashShowMaterialManager.j0(key, baseRequest, z16, j3, str, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(String key, BaseRequest baseRequest, boolean z16, long j3, String errMsg, Object obj) {
        Intrinsics.checkNotNullParameter(key, "$key");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.d("AEFlashShowMaterialManager", 1, "[sendFavoriteList] success:" + z16 + " retCode:" + j3 + " errMsg:" + errMsg);
        if (z16 && j3 == 0) {
            AECameraPrefsUtil.f().q(key, 0);
            QLog.i("AEFlashShowMaterialManager", 1, "[sendFavoriteList] delete local favoriteList key:" + key);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(AEFlashShowMaterialManager this$0, AppRuntime appRuntime, String str, AEMaterialMetaData aEMaterialMetaData, com.tencent.aelight.camera.download.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(appRuntime);
        Intrinsics.checkNotNull(str);
        this$0.q0(appRuntime, str, aEMaterialMetaData, aVar);
    }

    private final void q0(AppRuntime app, String downloadDir, AEMaterialMetaData data, com.tencent.aelight.camera.download.a listener) {
        String str;
        ((IAEDownloadMaterial) QRoute.api(IAEDownloadMaterial.class)).startDownloadMaterial(app, data, downloadDir, new e(listener));
        if (data == null) {
            str = "null";
        } else {
            str = data.f69050id;
        }
        ms.a.f("AEFlashShowMaterialManager", "\u3010START\u3011startDownloadMaterial :" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AEMaterialMetaData u(AEMaterialMetaData info) {
        if (TextUtils.isEmpty(info.f69050id)) {
            return null;
        }
        return this.mAEMaterialMap.get(info.f69050id);
    }

    public final List<AEMaterialCategory> A(boolean loadFavorite) {
        return this.mStickerMaterialList;
    }

    /* renamed from: C, reason: from getter */
    public final String getSelectedMaterialId() {
        return this.selectedMaterialId;
    }

    public final void F(final boolean forceRefresh) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.bi
            @Override // java.lang.Runnable
            public final void run() {
                AEFlashShowMaterialManager.G(AEFlashShowMaterialManager.this, forceRefresh);
            }
        }, 64, null, false);
    }

    public final void I(boolean forceRefresh) {
        H(forceRefresh);
    }

    public final synchronized boolean O(AEMaterialMetaData info) {
        boolean i3;
        if (info != null) {
            if (!TextUtils.isEmpty(info.name)) {
                i3 = AEMaterialManager.i(info);
            }
        }
        i3 = false;
        return i3;
    }

    public final void X(VideoMaterial data) {
        yq2.b bVar = this.mPtvTemplateObservable;
        if (bVar != null) {
            bVar.c(115, data);
        }
    }

    public final void Y(VideoMaterial data) {
        yq2.b bVar = this.mPtvTemplateObservable;
        if (bVar != null) {
            bVar.c(114, data);
        }
    }

    public final void Z() {
        ms.a.f("AEFlashShowMaterialManager", "onConfigRequestDone---notify all wait thread");
    }

    public final void b0() {
        yq2.b bVar = this.mPtvTemplateObservable;
        if (bVar != null) {
            bVar.c(111, this.mFavoriteCategory);
        }
    }

    public final synchronized void c0(int eventId) {
        yq2.b bVar = this.mPtvTemplateObservable;
        if (bVar != null) {
            bVar.d(eventId);
        }
    }

    public final synchronized void d0(yq2.c observer) {
        yq2.b bVar = this.mPtvTemplateObservable;
        if (bVar != null) {
            bVar.e(observer);
        }
    }

    public final void e0(final AEMaterialMetaData info) {
        boolean removeAll;
        Intrinsics.checkNotNullParameter(info, "info");
        ms.a.f("AEFlashShowMaterialManager", "removeMaterialFromFavorite");
        if (info.isNoneMaterial()) {
            return;
        }
        synchronized (this.mFavoriteListLock) {
            List<AEMaterialMetaData> list = this.mFavoriteCategory.f69044d;
            Intrinsics.checkNotNullExpressionValue(list, "mFavoriteCategory.materialList");
            removeAll = CollectionsKt__MutableCollectionsKt.removeAll((List) list, (Function1) new Function1<AEMaterialMetaData, Boolean>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager$removeMaterialFromFavorite$1$removed$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(AEMaterialMetaData aEMaterialMetaData) {
                    return Boolean.valueOf(Intrinsics.areEqual(aEMaterialMetaData.f69050id, AEMaterialMetaData.this.f69050id));
                }
            });
            if (removeAll) {
                ms.a.a("AEFlashShowMaterialManager", "found material in favorite category, remove and refresh");
                yq2.b bVar = this.mPtvTemplateObservable;
                if (bVar != null) {
                    bVar.c(111, this.mFavoriteCategory);
                    Unit unit = Unit.INSTANCE;
                }
            } else {
                ms.a.a("AEFlashShowMaterialManager", "not found material in favorite category, ignore");
                Unit unit2 = Unit.INSTANCE;
            }
        }
        AEFlashShowBottomPanelViewModel.INSTANCE.a().postValue(info);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f0(final AEMaterialMetaData aEMaterialMetaData, Continuation<? super Boolean> continuation) {
        AEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1 aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1;
        Object coroutine_suspended;
        int i3;
        Continuation intercepted;
        Object coroutine_suspended2;
        AEFlashShowMaterialManager aEFlashShowMaterialManager;
        boolean booleanValue;
        boolean removeAll;
        AEMaterialMetaData aEMaterialMetaData2;
        boolean z16;
        if (continuation instanceof AEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1) {
            aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1 = (AEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1) continuation;
            int i16 = aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1.label = i16 - Integer.MIN_VALUE;
                Object obj = aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ms.a.f("AEFlashShowMaterialManager", "removeMaterialFromFavoriteToServer");
                    if (aEMaterialMetaData.isNoneMaterial()) {
                        return Boxing.boxBoolean(false);
                    }
                    aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1.L$0 = this;
                    aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1.L$1 = aEMaterialMetaData;
                    aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1.label = 1;
                    intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1);
                    SafeContinuation safeContinuation = new SafeContinuation(intercepted);
                    o83.a aVar = o83.a.f422212a;
                    String str = aEMaterialMetaData.f69050id;
                    Intrinsics.checkNotNullExpressionValue(str, "info.id");
                    aVar.a("meterial", str, new d(safeContinuation));
                    obj = safeContinuation.getOrThrow();
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (obj == coroutine_suspended2) {
                        DebugProbes.probeCoroutineSuspended(aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1);
                    }
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    aEFlashShowMaterialManager = this;
                } else {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            z16 = aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1.Z$0;
                            aEMaterialMetaData2 = (AEMaterialMetaData) aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            booleanValue = z16;
                            aEMaterialMetaData = aEMaterialMetaData2;
                            AEFlashShowBottomPanelViewModel.INSTANCE.a().postValue(aEMaterialMetaData);
                            return Boxing.boxBoolean(booleanValue);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aEMaterialMetaData = (AEMaterialMetaData) aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1.L$1;
                    aEFlashShowMaterialManager = (AEFlashShowMaterialManager) aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                booleanValue = ((Boolean) obj).booleanValue();
                if (booleanValue) {
                    Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    synchronized (aEFlashShowMaterialManager.mFavoriteListLock) {
                        List<AEMaterialMetaData> list = aEFlashShowMaterialManager.mFavoriteCategory.f69044d;
                        Intrinsics.checkNotNullExpressionValue(list, "mFavoriteCategory.materialList");
                        removeAll = CollectionsKt__MutableCollectionsKt.removeAll((List) list, (Function1) new Function1<AEMaterialMetaData, Boolean>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(AEMaterialMetaData aEMaterialMetaData3) {
                                return Boolean.valueOf(Intrinsics.areEqual(aEMaterialMetaData3.f69050id, AEMaterialMetaData.this.f69050id));
                            }
                        });
                        booleanRef.element = removeAll;
                        Unit unit = Unit.INSTANCE;
                    }
                    if (removeAll) {
                        ms.a.a("AEFlashShowMaterialManager", "found material in favorite category, remove and refresh");
                        MainCoroutineDispatcher main = Dispatchers.getMain();
                        AEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$3 aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$3 = new AEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$3(aEFlashShowMaterialManager, null);
                        aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1.L$0 = aEMaterialMetaData;
                        aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1.L$1 = null;
                        aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1.Z$0 = booleanValue;
                        aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1.label = 2;
                        if (BuildersKt.withContext(main, aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$3, aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        aEMaterialMetaData2 = aEMaterialMetaData;
                        z16 = booleanValue;
                        booleanValue = z16;
                        aEMaterialMetaData = aEMaterialMetaData2;
                        AEFlashShowBottomPanelViewModel.INSTANCE.a().postValue(aEMaterialMetaData);
                    } else {
                        ms.a.a("AEFlashShowMaterialManager", "not found material in favorite category, ignore");
                        AEFlashShowBottomPanelViewModel.INSTANCE.a().postValue(aEMaterialMetaData);
                    }
                }
                return Boxing.boxBoolean(booleanValue);
            }
        }
        aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1 = new AEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1(this, continuation);
        Object obj2 = aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = aEFlashShowMaterialManager$removeMaterialFromFavoriteToServer$1.label;
        if (i3 != 0) {
        }
        booleanValue = ((Boolean) obj2).booleanValue();
        if (booleanValue) {
        }
        return Boxing.boxBoolean(booleanValue);
    }

    public final void h0() {
        if (this.mFavoriteCategory.f69044d.isEmpty()) {
            String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            AECameraPrefsUtil.f().p("recent_template_flash_show_list" + account, "", 0);
            if (QLog.isColorLevel()) {
                QLog.d("AEFlashShowMaterialManager", 2, "saveFavoriteMaterials isEmpty need clear$");
                return;
            }
            return;
        }
        synchronized (this.mFavoriteListLock) {
            StringBuilder sb5 = new StringBuilder();
            List<AEMaterialMetaData> materialList = this.mFavoriteCategory.f69044d;
            if (materialList != null) {
                Intrinsics.checkNotNullExpressionValue(materialList, "materialList");
                for (AEMaterialMetaData aEMaterialMetaData : materialList) {
                    if (!TextUtils.isEmpty(aEMaterialMetaData.f69050id) && !Intrinsics.areEqual(aEMaterialMetaData, AEMaterialMetaData.MATERIAL_NONE)) {
                        sb5.append(aEMaterialMetaData.f69050id);
                        sb5.append("|");
                        sb5.append(aEMaterialMetaData.categoryId);
                        sb5.append("$");
                    }
                }
            }
            if (TextUtils.isEmpty(sb5.toString())) {
                return;
            }
            String account2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            AECameraPrefsUtil.f().p("recent_template_flash_show_list" + account2, sb5.toString(), 0);
            if (QLog.isColorLevel()) {
                QLog.d("AEFlashShowMaterialManager", 2, "saveFavoriteMaterials list=" + ((Object) sb5));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void k0(boolean z16) {
        this.onlyReloadFavoriteList = z16;
    }

    public final void l0(AEMaterialCategory category) {
        f64551q = category;
    }

    public final void n0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.selectedMaterialId = str;
    }

    public final void o0(final AppRuntime app, final String downloadDir, final AEMaterialMetaData data, final com.tencent.aelight.camera.download.a listener) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.bj
            @Override // java.lang.Runnable
            public final void run() {
                AEFlashShowMaterialManager.p0(AEFlashShowMaterialManager.this, app, downloadDir, data, listener);
            }
        }, 128, null, true);
    }

    @Override // com.tencent.aelight.camera.ae.control.b
    public void onDestroy() {
        ms.a.f("AEFlashShowMaterialManager", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        yq2.b bVar = this.mPtvTemplateObservable;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // com.tencent.aelight.camera.ae.control.b
    public void onInit() {
        ms.a.f("AEFlashShowMaterialManager", "onInit");
    }

    public final synchronized void p(yq2.c adapterObserver, int eventId) {
        if (this.mPtvTemplateObservable == null) {
            this.mPtvTemplateObservable = new yq2.b();
        }
        yq2.b bVar = this.mPtvTemplateObservable;
        if (bVar != null) {
            bVar.a(adapterObserver, eventId);
        }
    }

    public final void q(final AEMaterialMetaData info) {
        Intrinsics.checkNotNullParameter(info, "info");
        ms.a.a("AEFlashShowMaterialManager", "addMaterialToFavorite");
        if (info.isNoneMaterial()) {
            return;
        }
        synchronized (this.mFavoriteListLock) {
            List<AEMaterialMetaData> addMaterialToFavorite$lambda$25$lambda$24 = this.mFavoriteCategory.f69044d;
            Intrinsics.checkNotNullExpressionValue(addMaterialToFavorite$lambda$25$lambda$24, "addMaterialToFavorite$lambda$25$lambda$24");
            CollectionsKt__MutableCollectionsKt.removeAll((List) addMaterialToFavorite$lambda$25$lambda$24, (Function1) new Function1<AEMaterialMetaData, Boolean>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager$addMaterialToFavorite$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(AEMaterialMetaData aEMaterialMetaData) {
                    return Boolean.valueOf(Intrinsics.areEqual(aEMaterialMetaData.f69050id, AEMaterialMetaData.this.f69050id));
                }
            });
            ((LinkedList) addMaterialToFavorite$lambda$25$lambda$24).addFirst(info);
            yq2.b bVar = this.mPtvTemplateObservable;
            if (bVar != null) {
                bVar.c(111, this.mFavoriteCategory);
            }
            AEFlashShowBottomPanelViewModel.INSTANCE.a().postValue(info);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object r(final AEMaterialMetaData aEMaterialMetaData, Continuation<? super Boolean> continuation) {
        AEFlashShowMaterialManager$addMaterialToFavoriteToServer$1 aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1;
        Object coroutine_suspended;
        int i3;
        Continuation intercepted;
        ArrayList arrayListOf;
        Object coroutine_suspended2;
        AEFlashShowMaterialManager aEFlashShowMaterialManager;
        boolean booleanValue;
        AEMaterialMetaData aEMaterialMetaData2;
        boolean z16;
        if (continuation instanceof AEFlashShowMaterialManager$addMaterialToFavoriteToServer$1) {
            aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1 = (AEFlashShowMaterialManager$addMaterialToFavoriteToServer$1) continuation;
            int i16 = aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1.label = i16 - Integer.MIN_VALUE;
                Object obj = aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ms.a.a("AEFlashShowMaterialManager", "addMaterialToFavoriteToServer");
                    if (aEMaterialMetaData.isNoneMaterial()) {
                        return Boxing.boxBoolean(false);
                    }
                    aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1.L$0 = this;
                    aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1.L$1 = aEMaterialMetaData;
                    aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1.label = 1;
                    intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1);
                    SafeContinuation safeContinuation = new SafeContinuation(intercepted);
                    o83.a aVar = o83.a.f422212a;
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(aEMaterialMetaData.f69050id);
                    aVar.e("meterial", arrayListOf, new b(safeContinuation));
                    obj = safeContinuation.getOrThrow();
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (obj == coroutine_suspended2) {
                        DebugProbes.probeCoroutineSuspended(aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1);
                    }
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    aEFlashShowMaterialManager = this;
                } else {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            z16 = aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1.Z$0;
                            aEMaterialMetaData2 = (AEMaterialMetaData) aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            AEFlashShowBottomPanelViewModel.INSTANCE.a().postValue(aEMaterialMetaData2);
                            booleanValue = z16;
                            return Boxing.boxBoolean(booleanValue);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aEMaterialMetaData = (AEMaterialMetaData) aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1.L$1;
                    aEFlashShowMaterialManager = (AEFlashShowMaterialManager) aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                booleanValue = ((Boolean) obj).booleanValue();
                if (booleanValue) {
                    synchronized (aEFlashShowMaterialManager.mFavoriteListLock) {
                        List<AEMaterialMetaData> addMaterialToFavoriteToServer$lambda$28$lambda$27 = aEFlashShowMaterialManager.mFavoriteCategory.f69044d;
                        Intrinsics.checkNotNullExpressionValue(addMaterialToFavoriteToServer$lambda$28$lambda$27, "addMaterialToFavoriteToServer$lambda$28$lambda$27");
                        CollectionsKt__MutableCollectionsKt.removeAll((List) addMaterialToFavoriteToServer$lambda$28$lambda$27, (Function1) new Function1<AEMaterialMetaData, Boolean>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager$addMaterialToFavoriteToServer$2$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(AEMaterialMetaData aEMaterialMetaData3) {
                                return Boolean.valueOf(Intrinsics.areEqual(aEMaterialMetaData3.f69050id, AEMaterialMetaData.this.f69050id));
                            }
                        });
                        ((LinkedList) addMaterialToFavoriteToServer$lambda$28$lambda$27).addFirst(aEMaterialMetaData);
                    }
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    AEFlashShowMaterialManager$addMaterialToFavoriteToServer$3 aEFlashShowMaterialManager$addMaterialToFavoriteToServer$3 = new AEFlashShowMaterialManager$addMaterialToFavoriteToServer$3(aEFlashShowMaterialManager, null);
                    aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1.L$0 = aEMaterialMetaData;
                    aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1.L$1 = null;
                    aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1.Z$0 = booleanValue;
                    aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1.label = 2;
                    if (BuildersKt.withContext(main, aEFlashShowMaterialManager$addMaterialToFavoriteToServer$3, aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    aEMaterialMetaData2 = aEMaterialMetaData;
                    z16 = booleanValue;
                    AEFlashShowBottomPanelViewModel.INSTANCE.a().postValue(aEMaterialMetaData2);
                    booleanValue = z16;
                }
                return Boxing.boxBoolean(booleanValue);
            }
        }
        aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1 = new AEFlashShowMaterialManager$addMaterialToFavoriteToServer$1(this, continuation);
        Object obj2 = aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = aEFlashShowMaterialManager$addMaterialToFavoriteToServer$1.label;
        if (i3 != 0) {
        }
        booleanValue = ((Boolean) obj2).booleanValue();
        if (booleanValue) {
        }
        return Boxing.boxBoolean(booleanValue);
    }

    public final List<AEMaterialCategory> v() {
        return this.mCosmeticMaterialList;
    }

    public final List<AEMaterialCategory> y() {
        return this.mFilterList;
    }

    public final ArrayList<AEMaterialCategory> z() {
        return this.mGuidePicList;
    }

    private final Object x(boolean z16, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        QLog.i("AEFlashShowMaterialManager", 1, "getFavoriteListFromServer...");
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        o83.a.f422212a.b("meterial", new c(safeContinuation, z16));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final void t() {
        f64550p = null;
    }

    private final void s(AEMaterialCategory category) {
        List<AEMaterialMetaData> list;
        if (category == null || (list = category.f69044d) == null) {
            return;
        }
        for (AEMaterialMetaData info : list) {
            if (info != null) {
                Intrinsics.checkNotNullExpressionValue(info, "info");
                info.usable = O(info);
            }
        }
    }

    public final void m0(AEMaterialMetaData info, boolean addToRecent) {
        String str;
        if (info == null) {
            str = "null";
        } else {
            str = info.f69050id;
        }
        ms.a.f("AEFlashShowMaterialManager", "setSelectedMaterialAndNotify---info=" + str + ", addToRecent=" + addToRecent);
        f64550p = info;
        yq2.b bVar = this.mPtvTemplateObservable;
        if (bVar != null) {
            bVar.c(113, new Object[0]);
        }
        AEFlashShowBottomPanelViewModel.INSTANCE.d().postValue(info);
    }

    public final void r0(AppRuntime app, AEMaterialMetaData data, com.tencent.aelight.camera.download.a listener) {
        if (data != null) {
            o0(app, data.getZipDownloadPath(), data, listener);
        }
    }

    private final String w() {
        String qqStr = HardCodeUtil.qqStr(R.string.y0i);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.ae_camera_flash_favorite)");
        return qqStr;
    }

    public final boolean K(AEMaterialMetaData info) {
        Object obj;
        boolean z16;
        if (info == null || info.isNoneMaterial()) {
            return false;
        }
        synchronized (this.mFavoriteListLock) {
            List<AEMaterialMetaData> list = this.mFavoriteCategory.f69044d;
            Intrinsics.checkNotNullExpressionValue(list, "mFavoriteCategory.materialList");
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((AEMaterialMetaData) obj).f69050id, info.f69050id)) {
                    break;
                }
            }
            z16 = obj != null;
        }
        return z16;
    }

    private final boolean J(AEMaterialCategory cat) {
        if (cat == null) {
            return false;
        }
        return cat.f69045e == 10003 || !cat.C;
    }

    private final boolean L(AEMaterialCategory cat) {
        if (cat == null) {
            return false;
        }
        return cat.f69045e == 10002 || !cat.C;
    }

    private final boolean M(AEMaterialCategory cat) {
        if (cat == null) {
            return false;
        }
        return cat.f69045e == 10005 || !cat.C;
    }

    private final boolean N(AEMaterialCategory cat) {
        if (cat == null) {
            return false;
        }
        return cat.f69045e == 10001 || !cat.C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Type inference failed for: r10v4, types: [T, java.lang.Object[], java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object R(Continuation<? super Unit> continuation) {
        AEFlashShowMaterialManager$loadFavoriteMaterialsFromNetwork$1 aEFlashShowMaterialManager$loadFavoriteMaterialsFromNetwork$1;
        Object coroutine_suspended;
        int i3;
        String str;
        if (continuation instanceof AEFlashShowMaterialManager$loadFavoriteMaterialsFromNetwork$1) {
            aEFlashShowMaterialManager$loadFavoriteMaterialsFromNetwork$1 = (AEFlashShowMaterialManager$loadFavoriteMaterialsFromNetwork$1) continuation;
            int i16 = aEFlashShowMaterialManager$loadFavoriteMaterialsFromNetwork$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                aEFlashShowMaterialManager$loadFavoriteMaterialsFromNetwork$1.label = i16 - Integer.MIN_VALUE;
                Object obj = aEFlashShowMaterialManager$loadFavoriteMaterialsFromNetwork$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = aEFlashShowMaterialManager$loadFavoriteMaterialsFromNetwork$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        QLog.d("AEFlashShowMaterialManager", 2, "getFavoriteListFromServer end");
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                QLog.i("AEFlashShowMaterialManager", 2, "start loadFavoriteMaterialsFromNetwork...");
                AEMaterialCategory aEMaterialCategory = this.mFavoriteCategory;
                String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
                if (this.mUseFlashShowMaterial) {
                    str = "recent_template_flash_show_list";
                } else {
                    str = "recent_template_list_new";
                }
                String j3 = AECameraPrefsUtil.f().j(str + account, null, 0);
                if (QLog.isColorLevel()) {
                    QLog.d("AEFlashShowMaterialManager", 2, "[loadFavoriteMaterialsFromNetwork] list=" + j3);
                }
                if (j3 == null) {
                    aEFlashShowMaterialManager$loadFavoriteMaterialsFromNetwork$1.label = 1;
                    if (x(true, aEFlashShowMaterialManager$loadFavoriteMaterialsFromNetwork$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                Object[] array = new Regex("\\$").split(j3, 0).toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array;
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                synchronized (this.mFavoriteListLock) {
                    List<AEMaterialMetaData> list = aEMaterialCategory.f69044d;
                    if (list != null) {
                        list.clear();
                    }
                    for (String str2 : strArr) {
                        ?? array2 = new Regex("\\|").split(str2, 0).toArray(new String[0]);
                        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        objectRef.element = array2;
                        if (((Object[]) array2).length == 2) {
                            String str3 = ((String[]) array2)[0];
                            AEMaterialMetaData D = str3 != null ? D(str3) : null;
                            if (!aEMaterialCategory.f69044d.contains(D)) {
                                if (!Intrinsics.areEqual(D != null ? D.f69050id : null, "0") && D != null) {
                                    aEMaterialCategory.f69044d.add(D);
                                }
                            }
                        }
                    }
                    i0(aEMaterialCategory, str + account);
                    Unit unit = Unit.INSTANCE;
                }
                QLog.d("AEFlashShowMaterialManager", 2, "getFavoriteListFromServer start");
                aEFlashShowMaterialManager$loadFavoriteMaterialsFromNetwork$1.label = 2;
                if (x(false, aEFlashShowMaterialManager$loadFavoriteMaterialsFromNetwork$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                QLog.d("AEFlashShowMaterialManager", 2, "getFavoriteListFromServer end");
                return Unit.INSTANCE;
            }
        }
        aEFlashShowMaterialManager$loadFavoriteMaterialsFromNetwork$1 = new AEFlashShowMaterialManager$loadFavoriteMaterialsFromNetwork$1(this, continuation);
        Object obj2 = aEFlashShowMaterialManager$loadFavoriteMaterialsFromNetwork$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = aEFlashShowMaterialManager$loadFavoriteMaterialsFromNetwork$1.label;
        if (i3 == 0) {
        }
    }
}
