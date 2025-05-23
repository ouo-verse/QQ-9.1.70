package com.tencent.mobileqq.wink.preview.datasource;

import android.graphics.Bitmap;
import android.net.Uri;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.b;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.components.Size;
import tl.h;
import u53.e;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u00102\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b0\u00101J\u0016\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&J\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0004J\u001f\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u0007J\u001b\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0013\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0007J1\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\b\b\u0002\u0010\u0016\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0003J#\u0010%\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&J#\u0010)\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010&R\u001b\u0010/\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/wink/preview/datasource/WinkBasePreviewShareDataSource;", "", "", "", "o", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "l", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "str", "", "maxLength", DomainData.DOMAIN_NAME, "Lkotlin/Pair;", "", h.F, WadlProxyConsts.KEY_MATERIAL, "b", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "p", "", "urlOrPath", "holderCount", "e", "(Ljava/util/List;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/tavcut/core/session/ICutSession;", SessionDbHelper.SESSION_ID, "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "editDataWrapper", "", "coverTimeUs", "k", "(Lcom/tencent/tavcut/core/session/ICutSession;Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", WadlProxyConsts.PARAM_FILENAME, "j", "oldPath", "newPath", "d", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "url", "savePath", "g", "Lcom/tencent/mobileqq/transfile/api/IHttpEngineService;", "a", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/transfile/api/IHttpEngineService;", "netEngine", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class WinkBasePreviewShareDataSource {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy netEngine;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/preview/datasource/WinkBasePreviewShareDataSource$c", "Lcom/tencent/mobileqq/transfile/INetEngineListener;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "onResp", "Lcom/tencent/mobileqq/transfile/NetReq;", "req", "", "curOffset", "totalLen", "onUpdateProgeress", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<String> f325381d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f325382e;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super String> cancellableContinuation, String str) {
            this.f325381d = cancellableContinuation;
            this.f325382e = str;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(@Nullable NetResp resp) {
            boolean z16;
            if (resp == null) {
                CancellableContinuation<String> cancellableContinuation = this.f325381d;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("download image null resp"))));
                return;
            }
            if (resp.mResult == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            w53.b.a("WinkBasePreviewShareDataSource", "download onResp: " + z16 + ",out path:" + this.f325382e);
            if (z16) {
                CancellableContinuation<String> cancellableContinuation2 = this.f325381d;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(this.f325382e));
                return;
            }
            CancellableContinuation<String> cancellableContinuation3 = this.f325381d;
            Result.Companion companion3 = Result.INSTANCE;
            cancellableContinuation3.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("download image fail " + resp.mErrCode + " " + resp.mHttpCode))));
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(@NotNull NetReq req, long curOffset, long totalLen) {
            Intrinsics.checkNotNullParameter(req, "req");
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/preview/datasource/WinkBasePreviewShareDataSource$d", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements ResDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Pair<MetaMaterial, Boolean>> f325383a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f325384b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f325385c;

        /* JADX WARN: Multi-variable type inference failed */
        d(Continuation<? super Pair<MetaMaterial, Boolean>> continuation, MetaMaterial metaMaterial, Ref.BooleanRef booleanRef) {
            this.f325383a = continuation;
            this.f325384b = metaMaterial;
            this.f325385c = booleanRef;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean isSuccess) {
            w53.b.a("WinkBasePreviewShareDataSource", "downloadMaterialed: " + isSuccess);
            if (isSuccess) {
                Continuation<Pair<MetaMaterial, Boolean>> continuation = this.f325383a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(new Pair(this.f325384b, Boolean.valueOf(this.f325385c.element))));
            } else {
                Continuation<Pair<MetaMaterial, Boolean>> continuation2 = this.f325383a;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("download mate fail"))));
            }
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int progress) {
            w53.b.a("WinkBasePreviewShareDataSource", "downloadMaterial: " + progress);
        }
    }

    public WinkBasePreviewShareDataSource() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IHttpEngineService>() { // from class: com.tencent.mobileqq.wink.preview.datasource.WinkBasePreviewShareDataSource$netEngine$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IHttpEngineService invoke() {
                IRuntimeService runtimeService = b.a().getRuntimeService(IHttpEngineService.class, "all");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "getAppInterface()\n      \u2026ava, ProcessConstant.ALL)");
                return (IHttpEngineService) runtimeService;
            }
        });
        this.netEngine = lazy;
    }

    static /* synthetic */ Object c(WinkBasePreviewShareDataSource winkBasePreviewShareDataSource, MetaMaterial metaMaterial, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        if (!WinkEditorResourceManager.a1().o2(metaMaterial)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            WinkEditorResourceManager.a1().h0(metaMaterial, new b(metaMaterial, safeContinuation));
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
        return Boxing.boxBoolean(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00f8 -> B:11:0x00fd). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ Object f(WinkBasePreviewShareDataSource winkBasePreviewShareDataSource, List<String> list, int i3, Continuation<? super List<String>> continuation) {
        WinkBasePreviewShareDataSource$downloadAndCopyResources$1 winkBasePreviewShareDataSource$downloadAndCopyResources$1;
        Object coroutine_suspended;
        int i16;
        int collectionSizeOrDefault;
        WinkBasePreviewShareDataSource winkBasePreviewShareDataSource2;
        Collection collection;
        WinkBasePreviewShareDataSource$downloadAndCopyResources$1 winkBasePreviewShareDataSource$downloadAndCopyResources$12;
        Iterator it;
        boolean isBlank;
        String substringAfterLast$default;
        boolean startsWith$default;
        WinkBasePreviewShareDataSource winkBasePreviewShareDataSource3;
        Iterator it5;
        Collection collection2;
        String str;
        if (continuation instanceof WinkBasePreviewShareDataSource$downloadAndCopyResources$1) {
            winkBasePreviewShareDataSource$downloadAndCopyResources$1 = (WinkBasePreviewShareDataSource$downloadAndCopyResources$1) continuation;
            int i17 = winkBasePreviewShareDataSource$downloadAndCopyResources$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                winkBasePreviewShareDataSource$downloadAndCopyResources$1.label = i17 - Integer.MIN_VALUE;
                Object obj = winkBasePreviewShareDataSource$downloadAndCopyResources$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = winkBasePreviewShareDataSource$downloadAndCopyResources$1.label;
                if (i16 == 0) {
                    if (i16 != 1) {
                        if (i16 == 2) {
                            collection = (Collection) winkBasePreviewShareDataSource$downloadAndCopyResources$1.L$3;
                            it5 = (Iterator) winkBasePreviewShareDataSource$downloadAndCopyResources$1.L$2;
                            collection2 = (Collection) winkBasePreviewShareDataSource$downloadAndCopyResources$1.L$1;
                            winkBasePreviewShareDataSource3 = (WinkBasePreviewShareDataSource) winkBasePreviewShareDataSource$downloadAndCopyResources$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            str = (String) obj;
                            WinkBasePreviewShareDataSource$downloadAndCopyResources$1 winkBasePreviewShareDataSource$downloadAndCopyResources$13 = winkBasePreviewShareDataSource$downloadAndCopyResources$1;
                            it = it5;
                            winkBasePreviewShareDataSource2 = winkBasePreviewShareDataSource3;
                            Object obj2 = coroutine_suspended;
                            collection.add(str);
                            winkBasePreviewShareDataSource$downloadAndCopyResources$12 = winkBasePreviewShareDataSource$downloadAndCopyResources$13;
                            collection = collection2;
                            coroutine_suspended = obj2;
                            if (it.hasNext()) {
                                String str2 = (String) it.next();
                                isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                                if (!isBlank) {
                                    substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(str2, "/", (String) null, 2, (Object) null);
                                    String j3 = winkBasePreviewShareDataSource2.j(substringAfterLast$default);
                                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str2, "http", false, 2, null);
                                    if (startsWith$default) {
                                        w53.b.a("WinkBasePreviewShareDataSource", "download image: " + str2);
                                        winkBasePreviewShareDataSource$downloadAndCopyResources$12.L$0 = winkBasePreviewShareDataSource2;
                                        winkBasePreviewShareDataSource$downloadAndCopyResources$12.L$1 = collection;
                                        winkBasePreviewShareDataSource$downloadAndCopyResources$12.L$2 = it;
                                        winkBasePreviewShareDataSource$downloadAndCopyResources$12.L$3 = collection;
                                        winkBasePreviewShareDataSource$downloadAndCopyResources$12.label = 1;
                                        Object g16 = winkBasePreviewShareDataSource2.g(str2, j3, winkBasePreviewShareDataSource$downloadAndCopyResources$12);
                                        if (g16 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        winkBasePreviewShareDataSource3 = winkBasePreviewShareDataSource2;
                                        it5 = it;
                                        winkBasePreviewShareDataSource$downloadAndCopyResources$1 = winkBasePreviewShareDataSource$downloadAndCopyResources$12;
                                        collection2 = collection;
                                        str = (String) g16;
                                        WinkBasePreviewShareDataSource$downloadAndCopyResources$1 winkBasePreviewShareDataSource$downloadAndCopyResources$132 = winkBasePreviewShareDataSource$downloadAndCopyResources$1;
                                        it = it5;
                                        winkBasePreviewShareDataSource2 = winkBasePreviewShareDataSource3;
                                        Object obj22 = coroutine_suspended;
                                        collection.add(str);
                                        winkBasePreviewShareDataSource$downloadAndCopyResources$12 = winkBasePreviewShareDataSource$downloadAndCopyResources$132;
                                        collection = collection2;
                                        coroutine_suspended = obj22;
                                        if (it.hasNext()) {
                                            return (List) collection;
                                        }
                                    } else {
                                        w53.b.a("WinkBasePreviewShareDataSource", "copy image: " + str2);
                                        winkBasePreviewShareDataSource$downloadAndCopyResources$12.L$0 = winkBasePreviewShareDataSource2;
                                        winkBasePreviewShareDataSource$downloadAndCopyResources$12.L$1 = collection;
                                        winkBasePreviewShareDataSource$downloadAndCopyResources$12.L$2 = it;
                                        winkBasePreviewShareDataSource$downloadAndCopyResources$12.L$3 = collection;
                                        winkBasePreviewShareDataSource$downloadAndCopyResources$12.label = 2;
                                        Object d16 = winkBasePreviewShareDataSource2.d(str2, j3, winkBasePreviewShareDataSource$downloadAndCopyResources$12);
                                        if (d16 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        winkBasePreviewShareDataSource3 = winkBasePreviewShareDataSource2;
                                        it5 = it;
                                        winkBasePreviewShareDataSource$downloadAndCopyResources$1 = winkBasePreviewShareDataSource$downloadAndCopyResources$12;
                                        obj = d16;
                                        collection2 = collection;
                                        str = (String) obj;
                                        WinkBasePreviewShareDataSource$downloadAndCopyResources$1 winkBasePreviewShareDataSource$downloadAndCopyResources$1322 = winkBasePreviewShareDataSource$downloadAndCopyResources$1;
                                        it = it5;
                                        winkBasePreviewShareDataSource2 = winkBasePreviewShareDataSource3;
                                        Object obj222 = coroutine_suspended;
                                        collection.add(str);
                                        winkBasePreviewShareDataSource$downloadAndCopyResources$12 = winkBasePreviewShareDataSource$downloadAndCopyResources$1322;
                                        collection = collection2;
                                        coroutine_suspended = obj222;
                                        if (it.hasNext()) {
                                        }
                                    }
                                } else {
                                    throw new IllegalArgumentException("invalid photo path");
                                }
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        collection = (Collection) winkBasePreviewShareDataSource$downloadAndCopyResources$1.L$3;
                        it5 = (Iterator) winkBasePreviewShareDataSource$downloadAndCopyResources$1.L$2;
                        collection2 = (Collection) winkBasePreviewShareDataSource$downloadAndCopyResources$1.L$1;
                        winkBasePreviewShareDataSource3 = (WinkBasePreviewShareDataSource) winkBasePreviewShareDataSource$downloadAndCopyResources$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        str = (String) obj;
                        WinkBasePreviewShareDataSource$downloadAndCopyResources$1 winkBasePreviewShareDataSource$downloadAndCopyResources$13222 = winkBasePreviewShareDataSource$downloadAndCopyResources$1;
                        it = it5;
                        winkBasePreviewShareDataSource2 = winkBasePreviewShareDataSource3;
                        Object obj2222 = coroutine_suspended;
                        collection.add(str);
                        winkBasePreviewShareDataSource$downloadAndCopyResources$12 = winkBasePreviewShareDataSource$downloadAndCopyResources$13222;
                        collection = collection2;
                        coroutine_suspended = obj2222;
                        if (it.hasNext()) {
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    List<String> list2 = list;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator it6 = list2.iterator();
                    winkBasePreviewShareDataSource2 = winkBasePreviewShareDataSource;
                    collection = arrayList;
                    winkBasePreviewShareDataSource$downloadAndCopyResources$12 = winkBasePreviewShareDataSource$downloadAndCopyResources$1;
                    it = it6;
                    if (it.hasNext()) {
                    }
                }
            }
        }
        winkBasePreviewShareDataSource$downloadAndCopyResources$1 = new WinkBasePreviewShareDataSource$downloadAndCopyResources$1(winkBasePreviewShareDataSource, continuation);
        Object obj3 = winkBasePreviewShareDataSource$downloadAndCopyResources$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = winkBasePreviewShareDataSource$downloadAndCopyResources$1.label;
        if (i16 == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ Object i(WinkBasePreviewShareDataSource winkBasePreviewShareDataSource, Continuation<? super Pair<MetaMaterial, Boolean>> continuation) {
        WinkBasePreviewShareDataSource$downloadMaterial$1 winkBasePreviewShareDataSource$downloadMaterial$1;
        Object coroutine_suspended;
        int i3;
        MetaMaterial metaMaterial;
        Continuation intercepted;
        Object coroutine_suspended2;
        if (continuation instanceof WinkBasePreviewShareDataSource$downloadMaterial$1) {
            winkBasePreviewShareDataSource$downloadMaterial$1 = (WinkBasePreviewShareDataSource$downloadMaterial$1) continuation;
            int i16 = winkBasePreviewShareDataSource$downloadMaterial$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkBasePreviewShareDataSource$downloadMaterial$1.label = i16 - Integer.MIN_VALUE;
                Object obj = winkBasePreviewShareDataSource$downloadMaterial$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkBasePreviewShareDataSource$downloadMaterial$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    winkBasePreviewShareDataSource$downloadMaterial$1.label = 1;
                    obj = winkBasePreviewShareDataSource.l(winkBasePreviewShareDataSource$downloadMaterial$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                metaMaterial = (MetaMaterial) obj;
                if (metaMaterial == null) {
                    winkBasePreviewShareDataSource$downloadMaterial$1.L$0 = metaMaterial;
                    winkBasePreviewShareDataSource$downloadMaterial$1.label = 2;
                    intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(winkBasePreviewShareDataSource$downloadMaterial$1);
                    SafeContinuation safeContinuation = new SafeContinuation(intercepted);
                    Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    booleanRef.element = true;
                    if (WinkEditorResourceManager.a1().q(metaMaterial)) {
                        booleanRef.element = false;
                    }
                    WinkEditorResourceManager.a1().f0(metaMaterial, new d(safeContinuation, metaMaterial, booleanRef));
                    obj = safeContinuation.getOrThrow();
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (obj == coroutine_suspended2) {
                        DebugProbes.probeCoroutineSuspended(winkBasePreviewShareDataSource$downloadMaterial$1);
                    }
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return obj;
                }
                throw new IllegalStateException("download mate fail");
            }
        }
        winkBasePreviewShareDataSource$downloadMaterial$1 = new WinkBasePreviewShareDataSource$downloadMaterial$1(winkBasePreviewShareDataSource, continuation);
        Object obj2 = winkBasePreviewShareDataSource$downloadMaterial$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkBasePreviewShareDataSource$downloadMaterial$1.label;
        if (i3 == 0) {
        }
        metaMaterial = (MetaMaterial) obj2;
        if (metaMaterial == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IHttpEngineService m() {
        return (IHttpEngineService) this.netEngine.getValue();
    }

    @Nullable
    public Object b(@NotNull MetaMaterial metaMaterial, @NotNull Continuation<? super Boolean> continuation) {
        return c(this, metaMaterial, continuation);
    }

    @Nullable
    public final Object d(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        try {
            if (Intrinsics.areEqual(new File(str).getParent(), new File(str2).getParent())) {
                safeContinuation.resumeWith(Result.m476constructorimpl(str));
            } else {
                FileUtils.copyFile(str, str2);
                safeContinuation.resumeWith(Result.m476constructorimpl(str2));
            }
        } catch (Exception e16) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(e16)));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public Object e(@NotNull List<String> list, int i3, @NotNull Continuation<? super List<String>> continuation) {
        return f(this, list, i3, continuation);
    }

    @Nullable
    public final Object g(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        try {
            Uri.parse(str);
            final HttpNetReq httpNetReq = new HttpNetReq();
            httpNetReq.mReqUrl = str;
            httpNetReq.mHttpMethod = 0;
            httpNetReq.mExcuteTimeLimit = 20000L;
            httpNetReq.mOutPath = str2;
            httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
            httpNetReq.mCallback = new c(cancellableContinuationImpl, str2);
            cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.preview.datasource.WinkBasePreviewShareDataSource$downloadImage$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                    invoke2(th5);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th5) {
                    WinkBasePreviewShareDataSource.this.m().cancelReq(httpNetReq);
                }
            });
            m().sendReq(httpNetReq);
        } catch (Throwable th5) {
            w53.b.d("WinkBasePreviewShareDataSource", "download result: " + th5, th5);
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(th5)));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Nullable
    public Object h(@NotNull Continuation<? super Pair<MetaMaterial, Boolean>> continuation) {
        return i(this, continuation);
    }

    @NotNull
    public final String j(@NotNull String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        String str = e.f438384a + File.separator;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str + System.currentTimeMillis() + fileName;
    }

    @Nullable
    public final Object k(@NotNull ICutSession iCutSession, @NotNull WinkEditDataWrapper winkEditDataWrapper, long j3, @NotNull Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        Bitmap c16 = com.tencent.mobileqq.wink.editor.cover.b.c(com.tencent.mobileqq.wink.editor.cover.b.f319709a, iCutSession, j3 / 1000, new Size(1080, 1920), com.tencent.mobileqq.wink.editor.draft.c.r(winkEditDataWrapper), null, null, 32, null);
        String str = null;
        if (c16 == null) {
            safeContinuation.resumeWith(Result.m476constructorimpl(null));
        } else {
            String str2 = u53.b.f438374e + "/video_cover_" + System.currentTimeMillis() + ".jpg";
            boolean saveBitmapToFile = FileUtils.saveBitmapToFile(c16, str2);
            Result.Companion companion = Result.INSTANCE;
            if (saveBitmapToFile) {
                str = str2;
            }
            safeContinuation.resumeWith(Result.m476constructorimpl(str));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public abstract Object l(@NotNull Continuation<? super MetaMaterial> continuation);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String n(@NotNull String str, int maxLength) {
        boolean z16;
        Intrinsics.checkNotNullParameter(str, "str");
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "";
        }
        if (str.length() > maxLength) {
            String substring = str.substring(0, maxLength);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return str;
    }

    @Nullable
    public abstract Map<String, String> o();

    @Nullable
    public final Object p(@NotNull Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        w53.b.a("WinkBasePreviewShareDataSource", "loadLightAssets");
        WinkExportUtils.R();
        Result.Companion companion = Result.INSTANCE;
        Unit unit = Unit.INSTANCE;
        safeContinuation.resumeWith(Result.m476constructorimpl(unit));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended2) {
            return orThrow;
        }
        return unit;
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/preview/datasource/WinkBasePreviewShareDataSource$b", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements ResDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f325379a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f325380b;

        /* JADX WARN: Multi-variable type inference failed */
        b(MetaMaterial metaMaterial, Continuation<? super Boolean> continuation) {
            this.f325379a = metaMaterial;
            this.f325380b = continuation;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean isSuccess) {
            if (isSuccess) {
                WinkEditorResourceManager.a1().i0(this.f325379a);
                Continuation<Boolean> continuation = this.f325380b;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
                return;
            }
            Continuation<Boolean> continuation2 = this.f325380b;
            Result.Companion companion2 = Result.INSTANCE;
            continuation2.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int progress) {
        }
    }
}
