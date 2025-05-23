package com.tencent.robot.adelie.homepage.ugc.viewmodel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.robot.adelie.constant.AdelieConstant;
import com.tencent.robot.adelie.homepage.download.AdelieGenerateImageRequest;
import com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateProgress;
import com.tencent.robot.adelie.homepage.ugc.view.AdelieUgcUtil;
import com.tencent.robot.adelie.homepage.utils.AdelieCroppingUtil;
import d24.AdelieAvatarExtraInfo;
import d24.AdelieAvatarInfo;
import d24.GenerateImageItem;
import d24.GenerateRequestExtra;
import d24.UgcBasicConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCGenerate$GenerateRequest;
import qshadow.ShadowAIGCGenerate$Media;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 r2\u00020\u0001:\u0003stuB\u0007\u00a2\u0006\u0004\bp\u0010qJL\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u000b28\u0010\n\u001a4\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0002J\u0006\u0010\u000e\u001a\u00020\u0003J\u0006\u0010\u000f\u001a\u00020\u0003J\u0010\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0013\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0014\u0010\u0017\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u0006\u0010\u0018\u001a\u00020\fJ\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u001c\u001a\u00020\u001bJ(\u0010 \u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u001fJ\u0006\u0010!\u001a\u00020\u001bJ\u0006\u0010\"\u001a\u00020\tJ\b\u0010#\u001a\u00020\tH\u0002J+\u0010%\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\t0$H\u0002J#\u0010)\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010(\u001a\u0004\u0018\u00010\u001bH\u0002\u00a2\u0006\u0004\b)\u0010*JJ\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020\f28\u0010\n\u001a4\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0002H\u0002J\u001c\u0010/\u001a\u00020\t2\u0006\u0010-\u001a\u00020\f2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010.H\u0002J\b\u00100\u001a\u00020\fH\u0002J\u001e\u00102\u001a\u00020\t2\u0006\u00101\u001a\u00020\u001b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u001fH\u0002J \u00106\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\f2\u0006\u00105\u001a\u000204H\u0002J\u0010\u00108\u001a\u00020\u00072\u0006\u00107\u001a\u00020\fH\u0002J\u001a\u0010;\u001a\u00020:2\u0006\u00109\u001a\u00020\u001b2\b\b\u0002\u00107\u001a\u00020\fH\u0002R\u0016\u0010>\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\"\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\"\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020&0\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010CR\u0018\u0010I\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u001c\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010V\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010UR\u0016\u0010X\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010=R\u0016\u0010Z\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010=R \u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010CR\u0016\u0010^\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010=R\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010h\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010KR\u0016\u0010k\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010o\u001a\u00020l8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010n\u00a8\u0006v"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel;", "Landroidx/lifecycle/ViewModel;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "result", "Ld24/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "callback", "", "", "i2", "o2", "b2", "Landroid/content/Context;", "context", "c2", "y2", "Lmqq/util/WeakReference;", "Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel$c;", "listener", "x2", "m2", "position", "w2", "", "k2", "basicConfig", "avatarInfo", "Lkotlin/Function0;", "t2", "l2", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "f2", "Lkotlin/Function1;", "e2", "", "errorCode", "errMsg", ICustomDataEditor.STRING_PARAM_2, "(Ljava/lang/Long;Ljava/lang/String;)V", "groupId", SemanticAttributes.DbSystemValues.H2, "id", "Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel$b;", "g2", ICustomDataEditor.NUMBER_PARAM_2, "localPath", "z2", "maxSize", "", "maxRatio", "d2", "index", "p2", "functionID", "Lqshadow/ShadowAIGCGenerate$GenerateRequest;", "q2", "i", "I", "selectedPosition", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ld24/g;", "selectedItem", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/Map;", "mCurrentFetchingImageItems", "D", "mCurrentFetchingTimeStamps", "E", "Ljava/lang/Long;", "mCurrentFetchingErrorCode", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "mCurrentFetchingErrorMsg", "Lcom/tencent/robot/adelie/homepage/ugc/AdelieAvatarGenerateProgress;", "G", "Lcom/tencent/robot/adelie/homepage/ugc/AdelieAvatarGenerateProgress;", "generateProgress", "H", "Lmqq/util/WeakReference;", "mUgcImageStateListener", "Lcom/tencent/robot/adelie/homepage/download/AdelieGenerateImageRequest;", "Lcom/tencent/robot/adelie/homepage/download/AdelieGenerateImageRequest;", "mRequest", "J", "generateImageStep", "K", "maxGenerateCount", "L", "successGenerateGroupMap", "M", "successGenerateItemCount", "Ld24/a;", "N", "Ld24/a;", "extraInfo", "Ld24/b;", "P", "Ld24/b;", "mAvatarInfo", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mAvatarOriginPrompt", BdhLogUtil.LogTag.Tag_Req, "Z", "inputPreprocessReady", "Lkotlinx/coroutines/CoroutineScope;", ExifInterface.LATITUDE_SOUTH, "Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "<init>", "()V", "T", "a", "b", "c", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieUgcImageViewModel extends ViewModel {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Long mCurrentFetchingErrorCode;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private String mCurrentFetchingErrorMsg;

    /* renamed from: M, reason: from kotlin metadata */
    private int successGenerateItemCount;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private AdelieAvatarExtraInfo extraInfo;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private AdelieAvatarInfo mAvatarInfo;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean inputPreprocessReady;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GenerateImageItem selectedItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int selectedPosition = -1;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private Map<Integer, GenerateImageItem> mCurrentFetchingImageItems = new LinkedHashMap();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private Map<Integer, Long> mCurrentFetchingTimeStamps = new LinkedHashMap();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private AdelieAvatarGenerateProgress generateProgress = new AdelieAvatarGenerateProgress();

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private WeakReference<c> mUgcImageStateListener = new WeakReference<>(null);

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final AdelieGenerateImageRequest mRequest = new AdelieGenerateImageRequest();

    /* renamed from: J, reason: from kotlin metadata */
    private int generateImageStep = 6;

    /* renamed from: K, reason: from kotlin metadata */
    private int maxGenerateCount = 4;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, Boolean> successGenerateGroupMap = new LinkedHashMap();

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private String mAvatarOriginPrompt = "";

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private CoroutineScope viewModelScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(WinkCoroutineScopes.f317652a.c()));

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel$b;", "", "Ld24/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "onFailure", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface b {
        void a(@NotNull GenerateImageItem item);

        void onFailure();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel$c;", "", "Ld24/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "loadingProgress", "", "a", "(Ld24/g;Ljava/lang/Integer;)V", "progress", "", "progressTip", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface c {
        void a(@Nullable GenerateImageItem item, @Nullable Integer loadingProgress);

        void b(int progress, @NotNull String progressTip);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel$d", "Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel$b;", "Ld24/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "onFailure", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d implements b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f366617b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, GenerateImageItem, Unit> f366618c;

        /* JADX WARN: Multi-variable type inference failed */
        d(int i3, Function2<? super Boolean, ? super GenerateImageItem, Unit> function2) {
            this.f366617b = i3;
            this.f366618c = function2;
        }

        @Override // com.tencent.robot.adelie.homepage.ugc.viewmodel.AdelieUgcImageViewModel.b
        public void a(@NotNull GenerateImageItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (Intrinsics.areEqual(AdelieUgcImageViewModel.this.successGenerateGroupMap.get(Integer.valueOf(this.f366617b)), Boolean.FALSE)) {
                AdelieUgcImageViewModel.this.successGenerateGroupMap.put(Integer.valueOf(this.f366617b), Boolean.TRUE);
            }
            AdelieUgcImageViewModel.this.successGenerateItemCount++;
            this.f366618c.invoke(Boolean.TRUE, item);
        }

        @Override // com.tencent.robot.adelie.homepage.ugc.viewmodel.AdelieUgcImageViewModel.b
        public void onFailure() {
            this.f366618c.invoke(Boolean.TRUE, null);
        }
    }

    private final boolean d2(String localPath, int maxSize, float maxRatio) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(localPath, options);
        int i3 = options.outWidth;
        int i16 = options.outHeight;
        if (i3 > 0 && i16 > 0) {
            if (i3 > maxSize || i16 > maxSize) {
                return true;
            }
            float f16 = i3;
            float f17 = i16;
            if (f16 / f17 > maxRatio || f17 / f16 > maxRatio) {
                return true;
            }
            return false;
        }
        AdelieAvatarInfo adelieAvatarInfo = this.mAvatarInfo;
        Intrinsics.checkNotNull(adelieAvatarInfo);
        QLog.i("AdelieUgcImageViewModel", 1, "checkReferImage: " + adelieAvatarInfo.getImageUrl() + " width or height is null");
        return false;
    }

    private final void e2(Function1<? super Boolean, Unit> callback) {
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new AdelieUgcImageViewModel$checkReferImageSafe$1(this, callback, r2(this, "input_preprocess", 0, 2, null), null), 3, null);
    }

    private final void f2() {
        boolean z16;
        int i3;
        if (this.inputPreprocessReady) {
            i3 = 2;
        } else {
            AdelieAvatarInfo adelieAvatarInfo = this.mAvatarInfo;
            Intrinsics.checkNotNull(adelieAvatarInfo);
            if (adelieAvatarInfo.getImageUrl().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i3 = 0;
            } else {
                i3 = 1;
            }
        }
        this.generateProgress.d(i3);
    }

    private final void g2(int id5, b callback) {
        ShadowAIGCGenerate$GenerateRequest shadowAIGCGenerate$GenerateRequest;
        Job launch$default;
        this.mCurrentFetchingTimeStamps.put(Integer.valueOf(id5), Long.valueOf(System.currentTimeMillis()));
        GenerateImageItem generateImageItem = this.mCurrentFetchingImageItems.get(Integer.valueOf(id5));
        if (generateImageItem != null) {
            shadowAIGCGenerate$GenerateRequest = generateImageItem.getGenerateRequest();
        } else {
            shadowAIGCGenerate$GenerateRequest = null;
        }
        ShadowAIGCGenerate$GenerateRequest shadowAIGCGenerate$GenerateRequest2 = shadowAIGCGenerate$GenerateRequest;
        if (shadowAIGCGenerate$GenerateRequest2 == null && callback != null) {
            callback.onFailure();
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new AdelieUgcImageViewModel$fetchUgcImage$1(this, shadowAIGCGenerate$GenerateRequest2, id5, callback, null), 3, null);
        launch$default.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h2(int groupId, Function2<? super Boolean, ? super GenerateImageItem, Unit> callback) {
        for (Map.Entry<Integer, GenerateImageItem> entry : this.mCurrentFetchingImageItems.entrySet()) {
            entry.getValue().g(q2("generate_image", (n2() * this.generateImageStep) + entry.getKey().intValue()));
        }
        this.successGenerateGroupMap.put(Integer.valueOf(groupId), Boolean.FALSE);
        Iterator<Map.Entry<Integer, GenerateImageItem>> it = this.mCurrentFetchingImageItems.entrySet().iterator();
        while (it.hasNext()) {
            g2(it.next().getKey().intValue(), new d(groupId, callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(final AdelieUgcImageViewModel this$0, final Function2 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.e2(new Function1<Boolean, Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.viewmodel.AdelieUgcImageViewModel$generateImageItems$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                Map map;
                AdelieAvatarGenerateProgress adelieAvatarGenerateProgress;
                if (!z16) {
                    map = AdelieUgcImageViewModel.this.mCurrentFetchingImageItems;
                    Iterator it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        ((GenerateImageItem) ((Map.Entry) it.next()).getValue()).i(2);
                    }
                    adelieAvatarGenerateProgress = AdelieUgcImageViewModel.this.generateProgress;
                    adelieAvatarGenerateProgress.f();
                    callback.invoke(Boolean.FALSE, null);
                    return;
                }
                AdelieUgcImageViewModel.this.inputPreprocessReady = true;
                AdelieUgcImageViewModel adelieUgcImageViewModel = AdelieUgcImageViewModel.this;
                adelieUgcImageViewModel.h2(adelieUgcImageViewModel.successGenerateGroupMap.size(), callback);
            }
        });
    }

    private final int n2() {
        Iterator<T> it = this.successGenerateGroupMap.values().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (((Boolean) it.next()).booleanValue()) {
                i3++;
            }
        }
        return i3;
    }

    private final GenerateImageItem p2(int index) {
        if (this.mAvatarInfo == null) {
            return new GenerateImageItem(0, null, null, null, 0, null, 63, null);
        }
        q2("generate_image", (n2() * this.generateImageStep) + index);
        AdelieAvatarExtraInfo adelieAvatarExtraInfo = new AdelieAvatarExtraInfo(0, null, null, false, false, null, null, null, 255, null);
        AdelieAvatarInfo adelieAvatarInfo = this.mAvatarInfo;
        Intrinsics.checkNotNull(adelieAvatarInfo);
        adelieAvatarExtraInfo.c(adelieAvatarInfo.getExtra().getIndex());
        AdelieAvatarInfo adelieAvatarInfo2 = this.mAvatarInfo;
        Intrinsics.checkNotNull(adelieAvatarInfo2);
        adelieAvatarExtraInfo.g(adelieAvatarInfo2.getExtra().getStyle());
        AdelieAvatarInfo adelieAvatarInfo3 = this.mAvatarInfo;
        Intrinsics.checkNotNull(adelieAvatarInfo3);
        adelieAvatarExtraInfo.d(adelieAvatarInfo3.getExtra().getPrompt());
        AdelieAvatarInfo adelieAvatarInfo4 = this.mAvatarInfo;
        Intrinsics.checkNotNull(adelieAvatarInfo4);
        adelieAvatarExtraInfo.i(adelieAvatarInfo4.getExtra().getIs_face_ref());
        AdelieAvatarInfo adelieAvatarInfo5 = this.mAvatarInfo;
        Intrinsics.checkNotNull(adelieAvatarInfo5);
        adelieAvatarExtraInfo.j(adelieAvatarInfo5.getExtra().getIs_style_ref());
        AdelieAvatarInfo adelieAvatarInfo6 = this.mAvatarInfo;
        Intrinsics.checkNotNull(adelieAvatarInfo6);
        adelieAvatarExtraInfo.e(adelieAvatarInfo6.getImageUrl());
        GenerateImageItem generateImageItem = new GenerateImageItem(0, null, null, null, 0, null, 63, null);
        generateImageItem.g(new ShadowAIGCGenerate$GenerateRequest());
        generateImageItem.f(adelieAvatarExtraInfo);
        return generateImageItem;
    }

    private final ShadowAIGCGenerate$GenerateRequest q2(String functionID, int index) {
        boolean z16;
        AdelieAvatarInfo adelieAvatarInfo = this.mAvatarInfo;
        if (adelieAvatarInfo == null) {
            return new ShadowAIGCGenerate$GenerateRequest();
        }
        Intrinsics.checkNotNull(adelieAvatarInfo);
        adelieAvatarInfo.getExtra().f(index);
        ShadowAIGCGenerate$GenerateRequest shadowAIGCGenerate$GenerateRequest = new ShadowAIGCGenerate$GenerateRequest();
        shadowAIGCGenerate$GenerateRequest.busi_id.set("ugc_bot");
        shadowAIGCGenerate$GenerateRequest.func_id.set(functionID);
        PBStringField pBStringField = shadowAIGCGenerate$GenerateRequest.extra;
        Gson gson = new Gson();
        AdelieAvatarInfo adelieAvatarInfo2 = this.mAvatarInfo;
        Intrinsics.checkNotNull(adelieAvatarInfo2);
        pBStringField.set(gson.toJson(adelieAvatarInfo2.getExtra()));
        AdelieAvatarInfo adelieAvatarInfo3 = this.mAvatarInfo;
        Intrinsics.checkNotNull(adelieAvatarInfo3);
        if (adelieAvatarInfo3.getImageUrl().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            PBRepeatMessageField<ShadowAIGCGenerate$Media> pBRepeatMessageField = shadowAIGCGenerate$GenerateRequest.medias;
            ShadowAIGCGenerate$Media shadowAIGCGenerate$Media = new ShadowAIGCGenerate$Media();
            if (Intrinsics.areEqual(functionID, "generate_image")) {
                PBStringField pBStringField2 = shadowAIGCGenerate$Media.extra;
                Gson gson2 = new Gson();
                AdelieAvatarInfo adelieAvatarInfo4 = this.mAvatarInfo;
                Intrinsics.checkNotNull(adelieAvatarInfo4);
                pBStringField2.set(gson2.toJson(adelieAvatarInfo4.getMediaExtra()));
            }
            shadowAIGCGenerate$Media.type.set(1);
            PBStringField pBStringField3 = shadowAIGCGenerate$Media.string_data;
            AdelieAvatarInfo adelieAvatarInfo5 = this.mAvatarInfo;
            Intrinsics.checkNotNull(adelieAvatarInfo5);
            pBStringField3.set(adelieAvatarInfo5.getImageUrl());
            pBRepeatMessageField.add(shadowAIGCGenerate$Media);
        }
        return shadowAIGCGenerate$GenerateRequest;
    }

    static /* synthetic */ ShadowAIGCGenerate$GenerateRequest r2(AdelieUgcImageViewModel adelieUgcImageViewModel, String str, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        return adelieUgcImageViewModel.q2(str, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s2(Long errorCode, String errMsg) {
        String str;
        this.mCurrentFetchingErrorCode = errorCode;
        this.mCurrentFetchingErrorMsg = errMsg;
        AdelieConstant adelieConstant = AdelieConstant.f365917a;
        if (adelieConstant.a().containsKey(errorCode)) {
            str = adelieConstant.a().get(errorCode);
        } else {
            str = "\u751f\u6210\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5";
        }
        this.mCurrentFetchingErrorMsg = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u2(final AdelieUgcImageViewModel this$0, final Function0 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        AdelieAvatarInfo adelieAvatarInfo = this$0.mAvatarInfo;
        Intrinsics.checkNotNull(adelieAvatarInfo);
        if (!this$0.d2(adelieAvatarInfo.getImageUrl(), 1280, 2.5f)) {
            AdelieAvatarInfo adelieAvatarInfo2 = this$0.mAvatarInfo;
            Intrinsics.checkNotNull(adelieAvatarInfo2);
            QLog.i("AdelieUgcImageViewModel", 1, "imageUrl: " + adelieAvatarInfo2.getImageUrl());
            AdelieAvatarInfo adelieAvatarInfo3 = this$0.mAvatarInfo;
            Intrinsics.checkNotNull(adelieAvatarInfo3);
            this$0.z2(adelieAvatarInfo3.getImageUrl(), callback);
            return;
        }
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Option obtain = Option.obtain();
        AdelieAvatarInfo adelieAvatarInfo4 = this$0.mAvatarInfo;
        Intrinsics.checkNotNull(adelieAvatarInfo4);
        Option localPath = obtain.setLocalPath(adelieAvatarInfo4.getImageUrl());
        Intrinsics.checkNotNullExpressionValue(localPath, "obtain().setLocalPath(mAvatarInfo!!.imageUrl)");
        qQPicLoader.e(localPath, new IPicLoadStateListener() { // from class: com.tencent.robot.adelie.homepage.ugc.viewmodel.c
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                AdelieUgcImageViewModel.v2(AdelieUgcImageViewModel.this, callback, loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v2(AdelieUgcImageViewModel this$0, Function0 callback, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (loadState == LoadState.STATE_SUCCESS) {
            QLog.i("AdelieUgcImageViewModel", 1, "load refer image success");
            AdelieCroppingUtil adelieCroppingUtil = AdelieCroppingUtil.f366635a;
            Bitmap resultBitMap = option.getResultBitMap();
            Intrinsics.checkNotNullExpressionValue(resultBitMap, "option.resultBitMap");
            String e16 = AdelieUgcUtil.f366571a.e(adelieCroppingUtil.d(resultBitMap, 1280, 2.5f), "adelie_avatar_refer_image.png", "adelie_avatar");
            if (e16 != null) {
                this$0.z2(e16, callback);
            } else {
                callback.invoke();
            }
        }
    }

    private final void z2(String localPath, Function0<Unit> callback) {
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "AdelieUgcImageViewModel_AdelieUtils_uploadOriginAndGetUrl", null, null, null, new AdelieUgcImageViewModel$uploadAvatarAndGetUrl$1(this, callback, localPath, null), 14, null);
        }
    }

    public final boolean b2() {
        if (!o2() && this.successGenerateItemCount >= this.maxGenerateCount * this.generateImageStep) {
            return true;
        }
        return false;
    }

    public final boolean c2(@Nullable Context context) {
        synchronized (this.mCurrentFetchingImageItems) {
            Iterator<Map.Entry<Integer, GenerateImageItem>> it = this.mCurrentFetchingImageItems.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().getState() != 2) {
                    return false;
                }
            }
            Unit unit = Unit.INSTANCE;
            y2(context);
            return true;
        }
    }

    @NotNull
    public final Map<Integer, GenerateImageItem> i2(@NotNull final Function2<? super Boolean, ? super GenerateImageItem, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mCurrentFetchingImageItems.clear();
        f2();
        int i3 = this.successGenerateItemCount;
        int i16 = this.maxGenerateCount;
        int i17 = this.generateImageStep;
        if (i3 >= i16 * i17) {
            return this.mCurrentFetchingImageItems;
        }
        for (int i18 = 0; i18 < i17; i18++) {
            this.mCurrentFetchingImageItems.put(Integer.valueOf(i18), p2(i18));
        }
        if (this.inputPreprocessReady) {
            h2(this.successGenerateGroupMap.size(), callback);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.ugc.viewmodel.b
                @Override // java.lang.Runnable
                public final void run() {
                    AdelieUgcImageViewModel.j2(AdelieUgcImageViewModel.this, callback);
                }
            }, 64, null, true);
        }
        return this.mCurrentFetchingImageItems;
    }

    @NotNull
    public final String k2() {
        String json = new Gson().toJson(this.extraInfo);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(extraInfo)");
        return json;
    }

    @NotNull
    /* renamed from: l2, reason: from getter */
    public final String getMAvatarOriginPrompt() {
        return this.mAvatarOriginPrompt;
    }

    /* renamed from: m2, reason: from getter */
    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    public final boolean o2() {
        synchronized (this.mCurrentFetchingImageItems) {
            Iterator<Map.Entry<Integer, GenerateImageItem>> it = this.mCurrentFetchingImageItems.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().getState() == 0) {
                    return true;
                }
            }
            Unit unit = Unit.INSTANCE;
            return false;
        }
    }

    public final void onDestroy() {
        CoroutineScopeKt.cancel$default(this.viewModelScope, null, 1, null);
    }

    public final void t2(@Nullable String basicConfig, @Nullable String avatarInfo, @NotNull final Function0<Unit> callback) {
        boolean z16;
        int i3;
        int i16;
        String str;
        String str2;
        String str3;
        boolean contains$default;
        GenerateRequestExtra extra;
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean z17 = true;
        if (avatarInfo != null && avatarInfo.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Gson gson = new Gson();
        UgcBasicConfig ugcBasicConfig = (UgcBasicConfig) gson.fromJson(basicConfig, UgcBasicConfig.class);
        if (ugcBasicConfig != null) {
            i3 = ugcBasicConfig.getRequestMaxCount();
        } else {
            i3 = 4;
        }
        this.maxGenerateCount = i3;
        if (ugcBasicConfig != null) {
            i16 = ugcBasicConfig.getPerRequestMaxImgCount();
        } else {
            i16 = 6;
        }
        this.generateImageStep = i16;
        AdelieAvatarInfo adelieAvatarInfo = (AdelieAvatarInfo) gson.fromJson(avatarInfo, AdelieAvatarInfo.class);
        this.mAvatarInfo = adelieAvatarInfo;
        if (adelieAvatarInfo == null || (extra = adelieAvatarInfo.getExtra()) == null || (str = extra.getPrompt()) == null) {
            str = "";
        }
        this.mAvatarOriginPrompt = str;
        AdelieAvatarInfo adelieAvatarInfo2 = this.mAvatarInfo;
        if (adelieAvatarInfo2 != null) {
            if (adelieAvatarInfo2 != null) {
                str2 = adelieAvatarInfo2.getImageUrl();
            } else {
                str2 = null;
            }
            if (str2 != null && str2.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                AdelieAvatarInfo adelieAvatarInfo3 = this.mAvatarInfo;
                if (adelieAvatarInfo3 != null) {
                    str3 = adelieAvatarInfo3.getImageUrl();
                } else {
                    str3 = null;
                }
                Intrinsics.checkNotNull(str3);
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str3, (CharSequence) "http", false, 2, (Object) null);
                if (!contains$default) {
                    f2();
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.ugc.viewmodel.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            AdelieUgcImageViewModel.u2(AdelieUgcImageViewModel.this, callback);
                        }
                    }, 64, null, false);
                    return;
                }
            }
        }
        callback.invoke();
    }

    public final void w2(int position, @Nullable GenerateImageItem item) {
        AdelieAvatarExtraInfo adelieAvatarExtraInfo;
        this.selectedPosition = position;
        this.selectedItem = item;
        if (item != null) {
            adelieAvatarExtraInfo = item.getExtraInfo();
        } else {
            adelieAvatarExtraInfo = null;
        }
        this.extraInfo = adelieAvatarExtraInfo;
        c cVar = this.mUgcImageStateListener.get();
        if (cVar != null) {
            cVar.a(item, 0);
        }
    }

    public final void x2(@NotNull WeakReference<c> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mUgcImageStateListener = listener;
        this.generateProgress.g(listener);
    }

    public final void y2(@Nullable final Context context) {
        final String str = this.mCurrentFetchingErrorMsg;
        if (str != null && context != null) {
            C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.viewmodel.AdelieUgcImageViewModel$showErrorToast$1$1
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
                    QQToast.makeText(context, 1, str, 0).show();
                }
            });
        }
    }
}
