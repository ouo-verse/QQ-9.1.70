package com.tencent.mobileqq.wink.picker.interceptor;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.WorkerThread;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.edit.manager.WinkPhotoListServiceHandler;
import com.tencent.mobileqq.wink.picker.MediaPickerInput;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.TemplateLibraryData;
import com.tencent.mobileqq.wink.picker.VideoTemplateData;
import com.tencent.mobileqq.wink.picker.core.viewmodel.b;
import com.tencent.mobileqq.winkpublish.report.MediaPickerErrorCode;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0016\u0018\u0000 >2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010$\u001a\u00020!\u00a2\u0006\u0004\b<\u0010=Jg\u0010\u0016\u001a\u00020\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000fH\u0003J\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\tJg\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000fJ\u0006\u0010\u001f\u001a\u00020\u0014J\u0006\u0010 \u001a\u00020\u0014R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00104R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u00107R\u0016\u0010;\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010:\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "", "Landroid/content/Intent;", "intent", "Lcom/tencent/mobileqq/wink/picker/TabType;", "mediaPickerTabType", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedia", "", "useVideoTemplate", "Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", "mediaPickerScene", "Lcom/tencent/mobileqq/wink/picker/d;", "templateLibraryData", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/wink/picker/b;", "Lkotlin/ParameterName;", "name", "output", "", "onJumpToWinkEditor", "k", "", "Lcom/tencent/mobileqq/wink/picker/interceptor/c;", "g", "loaded", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, tl.h.F, "f", "p", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/b;", "a", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/b;", "nextStepUIStateUpdater", "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRunning", "c", "Z", "isLightAssetsLoaded", "d", "Ljava/util/List;", "mediaInterceptors", "Lcom/tencent/mobileqq/wink/picker/interceptor/TemplateLibBaseMediaInterceptor;", "e", "Lcom/tencent/mobileqq/wink/picker/interceptor/TemplateLibBaseMediaInterceptor;", "templateLibMediaInterceptor", "Lcom/tencent/mobileqq/wink/picker/interceptor/j;", "Lcom/tencent/mobileqq/wink/picker/interceptor/j;", "templateLibReplaceMediaInterceptor", "Lcom/tencent/mobileqq/wink/picker/interceptor/CompressMediaInterceptor;", "Lcom/tencent/mobileqq/wink/picker/interceptor/CompressMediaInterceptor;", "compressMediaInterceptor", "", "J", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "<init>", "(Lcom/tencent/mobileqq/wink/picker/core/viewmodel/b;)V", "i", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class WinkMediaPickerNextStepHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.wink.picker.core.viewmodel.b nextStepUIStateUpdater;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public final AtomicBoolean isRunning;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isLightAssetsLoaded;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<c> mediaInterceptors;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TemplateLibBaseMediaInterceptor templateLibMediaInterceptor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j templateLibReplaceMediaInterceptor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CompressMediaInterceptor compressMediaInterceptor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile long taskId;

    public WinkMediaPickerNextStepHelper(@NotNull com.tencent.mobileqq.wink.picker.core.viewmodel.b nextStepUIStateUpdater) {
        Intrinsics.checkNotNullParameter(nextStepUIStateUpdater, "nextStepUIStateUpdater");
        this.nextStepUIStateUpdater = nextStepUIStateUpdater;
        this.isRunning = new AtomicBoolean(false);
    }

    private final List<c> g(Intent intent) {
        if (this.mediaInterceptors == null) {
            this.mediaInterceptors = new ArrayList();
            this.templateLibMediaInterceptor = new i();
            this.templateLibReplaceMediaInterceptor = new j();
            this.compressMediaInterceptor = new CompressMediaInterceptor();
            List<c> list = this.mediaInterceptors;
            Intrinsics.checkNotNull(list);
            List<c> list2 = list;
            list2.add(new DownloadQZoneMediaInterceptor());
            TemplateLibBaseMediaInterceptor templateLibBaseMediaInterceptor = this.templateLibMediaInterceptor;
            Intrinsics.checkNotNull(templateLibBaseMediaInterceptor);
            list2.add(templateLibBaseMediaInterceptor);
            j jVar = this.templateLibReplaceMediaInterceptor;
            Intrinsics.checkNotNull(jVar);
            list2.add(jVar);
            list2.add(new b());
            list2.add(new a());
            list2.add(new FetchMusicRecommendInterceptor());
            list2.add(new FetchRecommendTemplatesInterceptor(intent));
            list2.add(new FetchVideoTemplateInterceptor());
            list2.add(new g());
            CompressMediaInterceptor compressMediaInterceptor = this.compressMediaInterceptor;
            Intrinsics.checkNotNull(compressMediaInterceptor);
            list2.add(compressMediaInterceptor);
            list2.add(new f());
        }
        List<c> list3 = this.mediaInterceptors;
        Intrinsics.checkNotNull(list3);
        return list3;
    }

    public static /* synthetic */ void i(WinkMediaPickerNextStepHelper winkMediaPickerNextStepHelper, Activity activity, TabType tabType, List list, boolean z16, MediaPickerScene mediaPickerScene, TemplateLibraryData templateLibraryData, Function1 function1, int i3, Object obj) {
        boolean z17;
        MediaPickerScene mediaPickerScene2;
        TemplateLibraryData templateLibraryData2;
        if (obj == null) {
            if ((i3 & 8) != 0) {
                z17 = false;
            } else {
                z17 = z16;
            }
            if ((i3 & 16) != 0) {
                mediaPickerScene2 = MediaPickerScene.STANDARD;
            } else {
                mediaPickerScene2 = mediaPickerScene;
            }
            if ((i3 & 32) != 0) {
                templateLibraryData2 = null;
            } else {
                templateLibraryData2 = templateLibraryData;
            }
            winkMediaPickerNextStepHelper.h(activity, tabType, list, z17, mediaPickerScene2, templateLibraryData2, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: performClickNextStep");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(List selectedMedia, Intent intent, boolean z16, TemplateLibraryData templateLibraryData, WinkMediaPickerNextStepHelper this$0, TabType mediaPickerTabType, MediaPickerScene mediaPickerScene, Function1 onJumpToWinkEditor) {
        String str;
        boolean z17;
        Intrinsics.checkNotNullParameter(selectedMedia, "$selectedMedia");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaPickerTabType, "$mediaPickerTabType");
        Intrinsics.checkNotNullParameter(mediaPickerScene, "$mediaPickerScene");
        Intrinsics.checkNotNullParameter(onJumpToWinkEditor, "$onJumpToWinkEditor");
        if (selectedMedia.isEmpty()) {
            w53.b.c("WinkMediaPickerNextStepHelper", "performClickNextStep ==> selectedMedia is empty");
            if (intent == null || (str = intent.getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID)) == null) {
                str = "";
            }
            MediaInterceptorMonitor mediaInterceptorMonitor = MediaInterceptorMonitor.f324886a;
            if (templateLibraryData != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            mediaInterceptorMonitor.o(str, z16, z17);
            MediaPickerErrorCode mediaPickerErrorCode = new MediaPickerErrorCode(MediaPickerErrorCode.ERROR_CODE_EMPTY_SELECTED_MEDIA_DATA_DELAY, null, 2, null);
            mediaInterceptorMonitor.c(mediaPickerErrorCode.getMessage(), mediaPickerErrorCode);
            this$0.isRunning.set(false);
            return;
        }
        com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.j(selectedMedia, z16);
        this$0.k(intent, mediaPickerTabType, selectedMedia, z16, mediaPickerScene, templateLibraryData, onJumpToWinkEditor);
    }

    @WorkerThread
    private final void k(Intent intent, TabType mediaPickerTabType, List<? extends LocalMediaInfo> selectedMedia, boolean useVideoTemplate, MediaPickerScene mediaPickerScene, TemplateLibraryData templateLibraryData, Function1<? super MediaPickerOutput, Unit> onJumpToWinkEditor) {
        String joinToString$default;
        String str;
        boolean z16;
        int collectionSizeOrDefault;
        try {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(selectedMedia, ", ", null, null, 0, null, new Function1<LocalMediaInfo, CharSequence>() { // from class: com.tencent.mobileqq.wink.picker.interceptor.WinkMediaPickerNextStepHelper$performClickNextStepInner$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull LocalMediaInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return "[" + it.path + ", " + it.mediaWidth + "*" + it.mediaHeight + "]";
                }
            }, 30, null);
            w53.b.f("WinkMediaPickerNextStepHelper", "performClickNextStepInner ==> mediaPickerTabType:" + mediaPickerTabType + ", useVideoTemplate:" + useVideoTemplate + ", selectedMedia:" + joinToString$default);
            if (intent == null || (str = intent.getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID)) == null) {
                str = "";
            }
            MediaInterceptorMonitor mediaInterceptorMonitor = MediaInterceptorMonitor.f324886a;
            if (templateLibraryData != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            mediaInterceptorMonitor.o(str, useVideoTemplate, z16);
            List<? extends LocalMediaInfo> list = selectedMedia;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(e93.i.b((LocalMediaInfo) it.next()));
            }
            MediaPickerInput mediaPickerInput = new MediaPickerInput(this.nextStepUIStateUpdater, mediaPickerScene, mediaPickerTabType, arrayList, new VideoTemplateData(useVideoTemplate, false, null, 6, null), templateLibraryData, null, null, null, null, 960, null);
            d dVar = new d(g(intent), 0, mediaPickerInput, this.isRunning, this.taskId);
            MediaPickerOutput f16 = dVar.f(mediaPickerInput);
            this.isRunning.set(false);
            if (dVar.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String() != this.taskId) {
                w53.b.f("WinkMediaPickerNextStepHelper", "performClickNextStepInner ==> taskId doesn't match, discard the jump");
                return;
            }
            this.nextStepUIStateUpdater.z0();
            onJumpToWinkEditor.invoke(f16);
            MediaInterceptorMonitor.f324886a.b();
        } catch (Exception e16) {
            this.isRunning.set(false);
            b.a.a(this.nextStepUIStateUpdater, true, 0, 2, null);
            if (e16 instanceof InterceptException) {
                InterceptException interceptException = (InterceptException) e16;
                MediaInterceptorMonitor.f324886a.c(interceptException.getInterceptorName(), interceptException.getErrorCode());
                w53.b.c("WinkMediaPickerNextStepHelper", "performClickNextStepInner ==> exception: " + interceptException.getInterceptorName() + " " + interceptException.getErrorCode());
                if (interceptException.getErrorCode().transformedCode() == MediaPickerErrorCode.ERROR_CODE_USER_CANCEL) {
                    return;
                }
                if (Intrinsics.areEqual(interceptException.getInterceptorName(), "DownloadQZoneMediaInterceptor")) {
                    this.nextStepUIStateUpdater.b0(true);
                    return;
                }
                if (Intrinsics.areEqual(interceptException.getInterceptorName(), "TemplateLibMediaInterceptor") || Intrinsics.areEqual(interceptException.getInterceptorName(), "TemplateLibReplaceMediaInterceptor")) {
                    if (interceptException.getErrorCode().transformedCode() == MediaPickerErrorCode.ERROR_CODE_NO_NETWORK) {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.interceptor.l
                            @Override // java.lang.Runnable
                            public final void run() {
                                WinkMediaPickerNextStepHelper.l();
                            }
                        });
                        return;
                    } else if (interceptException.getErrorCode().transformedCode() == MediaPickerErrorCode.ERROR_CODE_TEMPLATE_LIB_DETAIL_ERROR_MSG) {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.interceptor.m
                            @Override // java.lang.Runnable
                            public final void run() {
                                WinkMediaPickerNextStepHelper.m(e16);
                            }
                        });
                        return;
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.interceptor.n
                            @Override // java.lang.Runnable
                            public final void run() {
                                WinkMediaPickerNextStepHelper.n();
                            }
                        });
                        return;
                    }
                }
            } else {
                MediaInterceptorMonitor.f324886a.c("UNKNOWN", new MediaPickerErrorCode(15L, null, 2, null));
                w53.b.d("WinkMediaPickerNextStepHelper", "performClickNextStepInner ==> exception:", e16);
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.interceptor.o
                @Override // java.lang.Runnable
                public final void run() {
                    WinkMediaPickerNextStepHelper.o(e16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l() {
        QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), R.string.f240027o2, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Exception e16) {
        Intrinsics.checkNotNullParameter(e16, "$e");
        QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), e16.getMessage(), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n() {
        QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), R.string.f240437p6, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Exception e16) {
        Intrinsics.checkNotNullParameter(e16, "$e");
        QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), R.string.f240277oq, 0).show();
    }

    public final void f() {
        BusinessHandler businessHandler;
        WinkPhotoListServiceHandler winkPhotoListServiceHandler;
        CompressMediaInterceptor compressMediaInterceptor = this.compressMediaInterceptor;
        if (compressMediaInterceptor != null) {
            compressMediaInterceptor.c();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            AppInterface e16 = com.tencent.mobileqq.wink.b.e();
            Unit unit = null;
            if (e16 != null) {
                businessHandler = e16.getBusinessHandler(WinkPhotoListServiceHandler.class.getName());
            } else {
                businessHandler = null;
            }
            if (businessHandler instanceof WinkPhotoListServiceHandler) {
                winkPhotoListServiceHandler = (WinkPhotoListServiceHandler) businessHandler;
            } else {
                winkPhotoListServiceHandler = null;
            }
            if (winkPhotoListServiceHandler != null) {
                winkPhotoListServiceHandler.t3();
                unit = Unit.INSTANCE;
            }
            Result.m476constructorimpl(unit);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        this.isRunning.set(false);
    }

    public final void h(@NotNull Activity activity, @NotNull final TabType mediaPickerTabType, @NotNull final List<? extends LocalMediaInfo> selectedMedia, final boolean useVideoTemplate, @NotNull final MediaPickerScene mediaPickerScene, @Nullable final TemplateLibraryData templateLibraryData, @NotNull final Function1<? super MediaPickerOutput, Unit> onJumpToWinkEditor) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(mediaPickerTabType, "mediaPickerTabType");
        Intrinsics.checkNotNullParameter(selectedMedia, "selectedMedia");
        Intrinsics.checkNotNullParameter(mediaPickerScene, "mediaPickerScene");
        Intrinsics.checkNotNullParameter(onJumpToWinkEditor, "onJumpToWinkEditor");
        if (FastClickUtils.isFastDoubleClick("WinkMediaPickerNextStepHelper", 1000L)) {
            return;
        }
        if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady()) {
            com.tencent.mobileqq.wink.picker.g gVar = com.tencent.mobileqq.wink.picker.g.f324860a;
            Intent intent = activity.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
            gVar.g(activity, intent, selectedMedia);
            activity.finish();
            return;
        }
        if (!this.isRunning.compareAndSet(false, true)) {
            return;
        }
        this.taskId = System.currentTimeMillis();
        if (useVideoTemplate) {
            com.tencent.mobileqq.wink.report.g.a();
        } else {
            com.tencent.mobileqq.wink.report.g.c();
        }
        if (!this.isLightAssetsLoaded) {
            if (!com.tencent.mobileqq.wink.editor.export.j.K()) {
                com.tencent.mobileqq.wink.picker.g gVar2 = com.tencent.mobileqq.wink.picker.g.f324860a;
                Intent intent2 = activity.getIntent();
                Intrinsics.checkNotNullExpressionValue(intent2, "activity.intent");
                gVar2.g(activity, intent2, selectedMedia);
                activity.finish();
                ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundleHighPriority(AEResInfo.LIGHT_RES_PAG.agentType);
                ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundleHighPriority(AEResInfo.LIGHT_RES_FILAMENT.agentType);
                ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundleHighPriority(AEResInfo.AE_RES_BASE_PACKAGE.agentType);
                return;
            }
            this.isLightAssetsLoaded = true;
        }
        com.tencent.mobileqq.wink.editor.util.m.f322645a.t(activity.getWindow().findViewById(android.R.id.content), activity);
        final Intent intent3 = activity.getIntent();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.interceptor.k
            @Override // java.lang.Runnable
            public final void run() {
                WinkMediaPickerNextStepHelper.j(selectedMedia, intent3, useVideoTemplate, templateLibraryData, this, mediaPickerTabType, mediaPickerScene, onJumpToWinkEditor);
            }
        }, 64, null, true);
    }

    public final void p() {
        AppInterface e16;
        AppInterface e17;
        f();
        TemplateLibBaseMediaInterceptor templateLibBaseMediaInterceptor = this.templateLibMediaInterceptor;
        if (templateLibBaseMediaInterceptor != null && (e17 = com.tencent.mobileqq.wink.b.e()) != null) {
            e17.removeObserver(templateLibBaseMediaInterceptor);
        }
        j jVar = this.templateLibReplaceMediaInterceptor;
        if (jVar != null && (e16 = com.tencent.mobileqq.wink.b.e()) != null) {
            e16.removeObserver(jVar);
        }
    }

    public final void q(boolean loaded) {
        this.isLightAssetsLoaded = loaded;
    }
}
