package com.tencent.state.square.resource;

import android.app.Application;
import android.view.View;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.state.square.DefaultDownloadListener;
import com.tencent.state.square.IHttpDownloader;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.ISquarePagView;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.apache.httpcore.message.TokenParser;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J0\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002RN\u0010\u0003\u001aB\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u0007 \u0006* \u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/resource/PAGLoader;", "", "()V", "cachedKeysMap", "", "", "kotlin.jvm.PlatformType", "", "", "playPAG", "", "url", "savedName", "pagView", "Lcom/tencent/state/square/api/ISquarePagView;", "option", "Lcom/tencent/state/square/resource/PAGLoaderOption;", "playPagFile", "file", "Ljava/io/File;", "weakPagView", "Lmqq/util/WeakReference;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class PAGLoader {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "PAGLoader";
    private static volatile PAGLoader instance;
    private final Map<Integer, String> cachedKeysMap = Collections.synchronizedMap(new HashMap());

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/square/resource/PAGLoader$Companion;", "", "()V", "TAG", "", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/state/square/resource/PAGLoader;", "getInstance", "playPAG", "", "url", "savedName", "pagView", "Lcom/tencent/state/square/api/ISquarePagView;", "option", "Lcom/tencent/state/square/resource/PAGLoaderOption;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final PAGLoader getInstance() {
            if (PAGLoader.instance == null) {
                synchronized (PAGLoader.class) {
                    if (PAGLoader.instance == null) {
                        PAGLoader.instance = new PAGLoader();
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return PAGLoader.instance;
        }

        public final void playPAG(String url, String savedName, ISquarePagView pagView, PAGLoaderOption option) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(savedName, "savedName");
            Intrinsics.checkNotNullParameter(pagView, "pagView");
            PAGLoader companion = getInstance();
            if (companion != null) {
                companion.playPAG(url, savedName, pagView, option);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playPagFile(final String url, final File file, final WeakReference<ISquarePagView> weakPagView, final PAGLoaderOption option) {
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.resource.PAGLoader$playPagFile$1
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
                Map map;
                Map map2;
                String str = url;
                map = PAGLoader.this.cachedKeysMap;
                ISquarePagView iSquarePagView = (ISquarePagView) weakPagView.get();
                if (!Intrinsics.areEqual(str, (String) map.get(Integer.valueOf((iSquarePagView != null ? iSquarePagView.getView() : null) != null ? r2.hashCode() : 0)))) {
                    return;
                }
                ISquarePagView iSquarePagView2 = (ISquarePagView) weakPagView.get();
                if (iSquarePagView2 != null) {
                    String absolutePath = file.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                    iSquarePagView2.setPagFile(absolutePath);
                }
                ISquarePagView iSquarePagView3 = (ISquarePagView) weakPagView.get();
                if (iSquarePagView3 != null) {
                    PAGLoaderOption pAGLoaderOption = option;
                    iSquarePagView3.playPag(pAGLoaderOption != null ? pAGLoaderOption.getRepeatCount() : 0);
                }
                map2 = PAGLoader.this.cachedKeysMap;
                ISquarePagView iSquarePagView4 = (ISquarePagView) weakPagView.get();
                View view = iSquarePagView4 != null ? iSquarePagView4.getView() : null;
                map2.remove(Integer.valueOf(view != null ? view.hashCode() : 0));
            }
        });
    }

    public final void playPAG(final String url, final String savedName, ISquarePagView pagView, final PAGLoaderOption option) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(savedName, "savedName");
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        Map<Integer, String> cachedKeysMap = this.cachedKeysMap;
        Intrinsics.checkNotNullExpressionValue(cachedKeysMap, "cachedKeysMap");
        cachedKeysMap.put(Integer.valueOf(pagView.getView().hashCode()), url);
        final WeakReference weakReference = new WeakReference(pagView);
        SquareBaseKt.getSquareThread().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.state.square.resource.PAGLoader$playPAG$1
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
                SquareBase squareBase = SquareBase.INSTANCE;
                Application app = squareBase.getApp();
                File file = new File(app != null ? app.getExternalFilesDir(null) : null, savedName);
                if (file.exists()) {
                    SquareBaseKt.getSquareLog().d(PAGLoader.TAG, "pag exists:" + url);
                    PAGLoader.this.playPagFile(url, file, weakReference, option);
                    return;
                }
                SquareBaseKt.getSquareLog().d(PAGLoader.TAG, "startDownload pag:" + url);
                String str = url;
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                squareBase.getConfig().getDownloader().download(new IHttpDownloader.Task(str, absolutePath), new DefaultDownloadListener() { // from class: com.tencent.state.square.resource.PAGLoader$playPAG$1.1
                    @Override // com.tencent.state.square.DefaultDownloadListener, com.tencent.state.square.IDownloadListener
                    public void onTaskFailed(int errorCode, String errorMessage) {
                        Map map;
                        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), PAGLoader.TAG, "onTaskFailed pag " + errorCode + TokenParser.SP + errorMessage, null, 4, null);
                        map = PAGLoader.this.cachedKeysMap;
                        ISquarePagView iSquarePagView = (ISquarePagView) weakReference.get();
                        View view = iSquarePagView != null ? iSquarePagView.getView() : null;
                        map.remove(Integer.valueOf(view != null ? view.hashCode() : 0));
                    }

                    @Override // com.tencent.state.square.DefaultDownloadListener, com.tencent.state.square.IDownloadListener
                    public void onTaskSuccess(File resultFile) {
                        Intrinsics.checkNotNullParameter(resultFile, "resultFile");
                        SquareBaseKt.getSquareLog().d(PAGLoader.TAG, "onTaskSuccess pag");
                        PAGLoader$playPAG$1 pAGLoader$playPAG$1 = PAGLoader$playPAG$1.this;
                        PAGLoader.this.playPagFile(url, resultFile, weakReference, option);
                    }
                });
            }
        });
    }
}
