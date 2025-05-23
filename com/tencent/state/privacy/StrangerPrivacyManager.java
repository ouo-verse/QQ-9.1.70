package com.tencent.state.privacy;

import android.app.Application;
import android.content.Context;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.state.library.focus.FocusDialogTips;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasSquareStrangerPrivacyService;
import com.tencent.state.square.IDownloadListener;
import com.tencent.state.square.IHttpDownloader;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.mmkv.IMMKV;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import wx4.d;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\u000eJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0012\u001a\u00020\nJ\u001a\u0010\u0013\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u0014J0\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/privacy/StrangerPrivacyManager;", "", "()V", "FILE_NAME_DIALOG_ICON", "", "SHOW_PRIVACY_DIALOG_SECONDS", "", "TAG", "URL_DIALOG_ICON", "checkAndShowDialog", "", "context", "Landroid/content/Context;", "callback", "Lkotlin/Function2;", "", "", "getDialogIconFilePath", "preloadRes", "queryStrangerVisible", "Lkotlin/Function1;", "setStrangerVisible", NodeProps.VISIBLE, UIJsPlugin.EVENT_SHOW_TOAST, "updateCache", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class StrangerPrivacyManager {
    private static final String FILE_NAME_DIALOG_ICON = "stranger_privacy_icon";
    public static final StrangerPrivacyManager INSTANCE = new StrangerPrivacyManager();
    public static final long SHOW_PRIVACY_DIALOG_SECONDS = 15;
    private static final String TAG = "StrangerPrivacyManager";
    private static final String URL_DIALOG_ICON = "https://vat-zplan-1251316161.file.myqcloud.com/square/ztp_square_stranger_alert_icon2%402x.png";

    StrangerPrivacyManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCache(boolean visible) {
        IMMKV.DefaultImpls.encodeInt$default(SquareBaseKt.getSquareMMKV(), SKey.Privacy.KEY_STRANGER_INVISIBLE, d.INSTANCE.b(visible), null, false, 12, null);
    }

    public final void checkAndShowDialog(final Context context, final Function2<? super Boolean, ? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        int decodeInt$default = IMMKV.DefaultImpls.decodeInt$default(SquareBaseKt.getSquareMMKV(), SKey.Privacy.KEY_STRANGER_INVISIBLE, -1, null, false, 12, null);
        SquareBaseKt.getSquareLog().d(TAG, "checkAndShowDialog enable:" + decodeInt$default);
        if (decodeInt$default == -1) {
            queryStrangerVisible(new Function1<Boolean, Unit>() { // from class: com.tencent.state.privacy.StrangerPrivacyManager$checkAndShowDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    if (z16) {
                        return;
                    }
                    FocusDialogTips.INSTANCE.checkAndShowStrangerPrivacyDialog(context, callback);
                }
            });
        }
    }

    public final String getDialogIconFilePath() {
        Application app = SquareBase.INSTANCE.getApp();
        File file = new File(app != null ? app.getExternalFilesDir(null) : null, FILE_NAME_DIALOG_ICON);
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public final void preloadRes() {
        SquareBase squareBase = SquareBase.INSTANCE;
        Application app = squareBase.getApp();
        File file = new File(app != null ? app.getExternalFilesDir(null) : null, FILE_NAME_DIALOG_ICON);
        if (file.exists()) {
            SquareBaseKt.getSquareLog().i(TAG, "icon exist");
            return;
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
        squareBase.getConfig().getDownloader().download(new IHttpDownloader.Task(URL_DIALOG_ICON, absolutePath), new IDownloadListener() { // from class: com.tencent.state.privacy.StrangerPrivacyManager$preloadRes$1
            @Override // com.tencent.state.square.IDownloadListener
            public boolean onTaskCheckFile(File file2) {
                return IDownloadListener.DefaultImpls.onTaskCheckFile(this, file2);
            }

            @Override // com.tencent.state.square.IDownloadListener
            public void onTaskFailed(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareBaseKt.getSquareLog().i("StrangerPrivacyManager", "preloadRes failed " + errorCode + TokenParser.SP + errorMessage);
            }

            @Override // com.tencent.state.square.IDownloadListener
            public void onTaskProgress(File tmpFile, byte[] data, int size, long progress) {
                Intrinsics.checkNotNullParameter(tmpFile, "tmpFile");
                Intrinsics.checkNotNullParameter(data, "data");
            }

            @Override // com.tencent.state.square.IDownloadListener
            public void onTaskSuccess(File resultFile) {
                Intrinsics.checkNotNullParameter(resultFile, "resultFile");
                SquareBaseKt.getSquareLog().i("StrangerPrivacyManager", "preloadRes success");
            }

            @Override // com.tencent.state.square.IDownloadListener
            public void onTaskStart() {
            }

            @Override // com.tencent.state.square.IDownloadListener
            public void onDownloadFinish(File tempFile) {
            }

            @Override // com.tencent.state.square.IDownloadListener
            public void onTaskResponse(long contentLength) {
            }
        });
    }

    public final void queryStrangerVisible(final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        VasSquareStrangerPrivacyService.INSTANCE.getStrangerVisible(new ResultCallback<Boolean>() { // from class: com.tencent.state.privacy.StrangerPrivacyManager$queryStrangerVisible$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
            }

            @Override // com.tencent.state.service.ResultCallback
            public /* bridge */ /* synthetic */ void onResultSuccess(Boolean bool) {
                onResultSuccess(bool.booleanValue());
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            public void onResultSuccess(boolean result) {
                Function1.this.invoke(Boolean.valueOf(result));
            }
        });
    }

    public final void setStrangerVisible(boolean visible, boolean showToast, Function1<? super Boolean, Unit> callback) {
        VasSquareStrangerPrivacyService.INSTANCE.setStrangerVisible(visible, new StrangerPrivacyManager$setStrangerVisible$1(visible, callback, showToast));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setStrangerVisible$default(StrangerPrivacyManager strangerPrivacyManager, boolean z16, boolean z17, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z17 = true;
        }
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        strangerPrivacyManager.setStrangerVisible(z16, z17, function1);
    }
}
