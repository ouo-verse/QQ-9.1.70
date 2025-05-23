package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.picker.TemplateLibraryData;
import com.tencent.mobileqq.wink.picker.interceptor.WinkMediaPickerNextStepHelper;
import com.tencent.mobileqq.wink.preprocess.WinkMaterialResourceLoader;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 \u001e*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u00014BL\u0012\u0006\u00108\u001a\u000203\u0012\u0006\u0010>\u001a\u000209\u0012\u000e\b\u0002\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00030?\u0012#\b\u0002\u0010M\u001a\u001d\u0012\u0013\u0012\u00110F\u00a2\u0006\f\bG\u0012\b\bH\u0012\u0004\b\b(I\u0012\u0004\u0012\u00020\u00030E\u00a2\u0006\u0004\bV\u0010WJ\u0013\u0010\u0004\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J'\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\n\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0012J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0014J1\u0010\u001a\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H&\u00a2\u0006\u0004\b\u001a\u0010\u001bJA\u0010\u001e\u001a\u00020\u0003*\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u001cj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\u001d2\u0006\u0010\u0010\u001a\u00028\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tH&\u00a2\u0006\u0004\b\u001e\u0010\u001fJ!\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH\u0014\u00a2\u0006\u0004\b!\u0010\"J\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0010\u001a\u00028\u0000H&\u00a2\u0006\u0004\b#\u0010$J\u001d\u0010%\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&J#\u0010'\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00172\u0006\u0010\u0010\u001a\u00028\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010&Jv\u00102\u001a\u00020\u00032\u0006\u0010)\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010\f2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\b\u0010,\u001a\u0004\u0018\u00010\f2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010.\u001a\u0004\u0018\u00010\f2\u0006\u00100\u001a\u00020/2\"\u00101\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u001cj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\u001dH&R\u0017\u00108\u001a\u0002038\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0017\u0010>\u001a\u0002098\u0006\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00030?8\u0006\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR2\u0010M\u001a\u001d\u0012\u0013\u0012\u00110F\u00a2\u0006\f\bG\u0012\b\bH\u0012\u0004\b\b(I\u0012\u0004\u0012\u00020\u00030E8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010J\u001a\u0004\bK\u0010LR\u001a\u0010R\u001a\u00020N8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010O\u001a\u0004\bP\u0010QR\u0014\u0010U\u001a\u00020\f8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\bS\u0010T\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/adapter/click/BaseWinkAlbumClickDelegator;", "T", "", "", "v", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Intent;", "intent", "d", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "", "", "e", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data", ReportConstant.COSTREPORT_PREFIX, "(Ljava/lang/Object;)V", "t", "Lcom/tencent/mobileqq/wink/picker/b;", "output", "u", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedias", "g", "(Landroid/content/Intent;Ljava/lang/Object;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/util/List;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "f", "(Ljava/util/HashMap;Ljava/lang/Object;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "Lcom/tencent/mobileqq/wink/picker/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/Object;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Lcom/tencent/mobileqq/wink/picker/d;", "p", "(Ljava/lang/Object;)Ljava/util/List;", "k", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "l", "Landroid/content/Context;", "context", QQWinkConstants.STORY_ID, "templateIds", "firstMediaPath", "mediaInfoList", "classifyId", "", "maxPicNum", Node.ATTRS_ATTR, "r", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", h.F, "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "b", "Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "nextStepHelper", "Lkotlin/Function0;", "c", "Lkotlin/jvm/functions/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onBeforeLoad", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "Lkotlin/jvm/functions/Function1;", DomainData.DOMAIN_NAME, "()Lkotlin/jvm/functions/Function1;", "onAfterLoad", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "j", "()Lkotlinx/coroutines/CoroutineScope;", "mainScope", "i", "()Ljava/lang/String;", "logTag", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class BaseWinkAlbumClickDelegator<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkMediaPickerNextStepHelper nextStepHelper;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> onBeforeLoad;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Boolean, Unit> onAfterLoad;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope mainScope;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BaseWinkAlbumClickDelegator f326541d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CoroutineExceptionHandler.Companion companion, BaseWinkAlbumClickDelegator baseWinkAlbumClickDelegator) {
            super(companion);
            this.f326541d = baseWinkAlbumClickDelegator;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            QLog.e(this.f326541d.i(), 1, "onAlbumItemClick, error ", exception);
            BuildersKt__Builders_commonKt.launch$default(this.f326541d.getMainScope(), null, null, new BaseWinkAlbumClickDelegator$onAlbumItemClick$1$1(this.f326541d, null), 3, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BaseWinkAlbumClickDelegator f326542d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CoroutineExceptionHandler.Companion companion, BaseWinkAlbumClickDelegator baseWinkAlbumClickDelegator) {
            super(companion);
            this.f326542d = baseWinkAlbumClickDelegator;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            QLog.e(this.f326542d.i(), 1, "onAlbumItemClick, error ", exception);
            BuildersKt__Builders_commonKt.launch$default(this.f326542d.getMainScope(), null, null, new BaseWinkAlbumClickDelegator$onAlbumItemClick2$1$1(this.f326542d, null), 3, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseWinkAlbumClickDelegator(@NotNull Activity activity, @NotNull WinkMediaPickerNextStepHelper nextStepHelper, @NotNull Function0<Unit> onBeforeLoad, @NotNull Function1<? super Boolean, Unit> onAfterLoad) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(nextStepHelper, "nextStepHelper");
        Intrinsics.checkNotNullParameter(onBeforeLoad, "onBeforeLoad");
        Intrinsics.checkNotNullParameter(onAfterLoad, "onAfterLoad");
        this.activity = activity;
        this.nextStepHelper = nextStepHelper;
        this.onBeforeLoad = onBeforeLoad;
        this.onAfterLoad = onAfterLoad;
        this.mainScope = CoroutineScopeKt.MainScope();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent d(Intent intent) {
        Intent putExtras = new Intent().putExtras(intent);
        Intrinsics.checkNotNullExpressionValue(putExtras, "Intent().putExtras(intent)");
        putExtras.putExtra(QQWinkConstants.MEDIA_PICKER_SCENE, MediaPickerScene.TEMPLATE_LIBRARY_MEMORY_ALBUM);
        putExtras.putExtra(QQWinkConstants.NEED_AUTO_FILL_TEMPLATE_LIBRARY_HOLDERS, true);
        return putExtras;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(MetaMaterial metaMaterial, Continuation<? super Map<String, Long>> continuation) {
        BaseWinkAlbumClickDelegator$downloadMaterialRes$1 baseWinkAlbumClickDelegator$downloadMaterialRes$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof BaseWinkAlbumClickDelegator$downloadMaterialRes$1) {
            baseWinkAlbumClickDelegator$downloadMaterialRes$1 = (BaseWinkAlbumClickDelegator$downloadMaterialRes$1) continuation;
            int i16 = baseWinkAlbumClickDelegator$downloadMaterialRes$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                baseWinkAlbumClickDelegator$downloadMaterialRes$1.label = i16 - Integer.MIN_VALUE;
                Object obj = baseWinkAlbumClickDelegator$downloadMaterialRes$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = baseWinkAlbumClickDelegator$downloadMaterialRes$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        HashMap hashMap = (HashMap) baseWinkAlbumClickDelegator$downloadMaterialRes$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return hashMap;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                HashMap<String, Long> hashMap2 = new HashMap<>();
                WinkMaterialResourceLoader winkMaterialResourceLoader = WinkMaterialResourceLoader.f325333a;
                baseWinkAlbumClickDelegator$downloadMaterialRes$1.L$0 = hashMap2;
                baseWinkAlbumClickDelegator$downloadMaterialRes$1.label = 1;
                if (winkMaterialResourceLoader.i(metaMaterial, hashMap2, baseWinkAlbumClickDelegator$downloadMaterialRes$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return hashMap2;
            }
        }
        baseWinkAlbumClickDelegator$downloadMaterialRes$1 = new BaseWinkAlbumClickDelegator$downloadMaterialRes$1(this, continuation);
        Object obj2 = baseWinkAlbumClickDelegator$downloadMaterialRes$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = baseWinkAlbumClickDelegator$downloadMaterialRes$1.label;
        if (i3 == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object v(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new BaseWinkAlbumClickDelegator$toastErrorMsg$2(this, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (withContext == coroutine_suspended) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public abstract void f(@NotNull HashMap<String, String> hashMap, T t16, @Nullable MetaMaterial metaMaterial);

    public abstract void g(@NotNull Intent intent, T t16, @NotNull MetaMaterial metaMaterial, @NotNull List<? extends LocalMediaInfo> list);

    @NotNull
    /* renamed from: h, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public String i() {
        return "BaseWinkAlbumClickDelegator";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: j, reason: from getter */
    public final CoroutineScope getMainScope() {
        return this.mainScope;
    }

    @Nullable
    public abstract Object k(T t16, @NotNull Continuation<? super MetaMaterial> continuation);

    @Nullable
    public abstract Object l(T t16, @NotNull Continuation<? super List<MetaMaterial>> continuation);

    @NotNull
    /* renamed from: m, reason: from getter */
    public final WinkMediaPickerNextStepHelper getNextStepHelper() {
        return this.nextStepHelper;
    }

    @NotNull
    public final Function1<Boolean, Unit> n() {
        return this.onAfterLoad;
    }

    @NotNull
    public final Function0<Unit> o() {
        return this.onBeforeLoad;
    }

    @NotNull
    public abstract List<LocalMediaInfo> p(T data);

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public TemplateLibraryData q(T data, @NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        return null;
    }

    public abstract void r(@NotNull Context context, @Nullable String storyId, @NotNull List<String> templateIds, @Nullable String firstMediaPath, @NotNull List<? extends LocalMediaInfo> mediaInfoList, @Nullable String classifyId, int maxPicNum, @NotNull HashMap<String, String> attrs);

    public final void s(T data) {
        BuildersKt__Builders_commonKt.launch$default(this.mainScope, new b(CoroutineExceptionHandler.INSTANCE, this), null, new BaseWinkAlbumClickDelegator$onAlbumItemClick$2(this, data, null), 2, null);
    }

    public final void t(T data) {
        BuildersKt__Builders_commonKt.launch$default(this.mainScope, new c(CoroutineExceptionHandler.INSTANCE, this), null, new BaseWinkAlbumClickDelegator$onAlbumItemClick2$2(this, data, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public MediaPickerOutput u(@NotNull MediaPickerOutput output) {
        Intrinsics.checkNotNullParameter(output, "output");
        return output;
    }
}
