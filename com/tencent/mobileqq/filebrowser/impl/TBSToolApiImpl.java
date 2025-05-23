package com.tencent.mobileqq.filebrowser.impl;

import android.app.Activity;
import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultLauncher;
import com.tencent.luggage.wxa.bf.l0;
import com.tencent.mobileqq.filebrowser.ITBSToolApi;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.preview.TBSToolMediaPreviewLayerFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.tbstool.FileImporter;
import com.tencent.mobileqq.tbstool.TBSToolClientUtils;
import com.tencent.mobileqq.tbstool.TBSToolIPCModule;
import com.tencent.mobileqq.tbstool.TBSToolInjector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.gallery.RFWLayerFragment;
import com.tencent.tbs.reader.tool.ITbsToolHost;
import com.tencent.tbs.reader.tool.TbsToolEntrance;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0016J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J0\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001f2\u0006\u0010\u0018\u001a\u00020 2\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\t\u0012\u0004\u0012\u00020\u00040!H\u0016J4\u0010\"\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00040!H\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0016\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/filebrowser/impl/TBSToolApiImpl;", "Lcom/tencent/mobileqq/filebrowser/ITBSToolApi;", "()V", "forwardTBSToolFile", "", "filePath", "", "forwardTBSToolFileList", "fileList", "", "getFileListByExt", "extArray", "", "callback", "getMediaLayerFragment", "Ljava/lang/Class;", "Lcom/tencent/richframework/gallery/RFWLayerFragment;", "getTBSToolIPCModule", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "openFile", "sessionId", "", "path", "openWebPage", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "args", "pickPhotoFromAlbum", "Landroid/content/Intent;", "pickPhotoFromCamera", "registerAlbumActivityResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroidx/activity/ComponentActivity;", "Lkotlin/Function1;", l0.NAME, "tempFilePath", "srcFileName", "newSaveCallback", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "startWatchTopActivity", "stopWatchTopActivity", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class TBSToolApiImpl implements ITBSToolApi {
    static IPatchRedirector $redirector_;

    public TBSToolApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.ITBSToolApi
    public void forwardTBSToolFile(@NotNull String filePath) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) filePath);
            return;
        }
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        TBSToolClientUtils tBSToolClientUtils = TBSToolClientUtils.f291401a;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(filePath);
        tBSToolClientUtils.s(arrayListOf);
    }

    @Override // com.tencent.mobileqq.filebrowser.ITBSToolApi
    public void forwardTBSToolFileList(@NotNull List<String> fileList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) fileList);
        } else {
            Intrinsics.checkNotNullParameter(fileList, "fileList");
            TBSToolClientUtils.f291401a.s(fileList);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.ITBSToolApi
    public void getFileListByExt(@Nullable Object extArray, @Nullable Object callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, extArray, callback);
        } else {
            TBSToolClientUtils.f291401a.t(extArray, callback);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.ITBSToolApi
    @NotNull
    public Class<? extends RFWLayerFragment> getMediaLayerFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Class) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return TBSToolMediaPreviewLayerFragment.class;
    }

    @Override // com.tencent.mobileqq.filebrowser.ITBSToolApi
    @NotNull
    public QIPCModule getTBSToolIPCModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QIPCModule) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TBSToolIPCModule.INSTANCE.a();
    }

    @Override // com.tencent.mobileqq.filebrowser.ITBSToolApi
    public void openFile(@NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) path);
        } else {
            Intrinsics.checkNotNullParameter(path, "path");
            TBSToolClientUtils.f291401a.z(path);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.ITBSToolApi
    public void openWebPage(@NotNull Activity activity, @Nullable Object args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity, args);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
            TBSToolClientUtils.f291401a.D(activity, args);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.ITBSToolApi
    @NotNull
    public Intent pickPhotoFromAlbum(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Intent) iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        return FileImporter.f291396a.k(activity);
    }

    @Override // com.tencent.mobileqq.filebrowser.ITBSToolApi
    public void pickPhotoFromCamera(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
            FileImporter.f291396a.f(activity);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.ITBSToolApi
    @NotNull
    public ActivityResultLauncher<Intent> registerAlbumActivityResult(@NotNull ComponentActivity activity, @NotNull Function1<? super List<String>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ActivityResultLauncher) iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity, (Object) callback);
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return TBSToolClientUtils.f291401a.E(activity, callback);
    }

    @Override // com.tencent.mobileqq.filebrowser.ITBSToolApi
    public void saveFile(long sessionId, @NotNull String tempFilePath, @NotNull String srcFileName, @NotNull Function1<? super FileManagerEntity, Unit> newSaveCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Long.valueOf(sessionId), tempFilePath, srcFileName, newSaveCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(tempFilePath, "tempFilePath");
        Intrinsics.checkNotNullParameter(srcFileName, "srcFileName");
        Intrinsics.checkNotNullParameter(newSaveCallback, "newSaveCallback");
        TBSToolClientUtils.H(TBSToolClientUtils.f291401a, sessionId, tempFilePath, srcFileName, newSaveCallback, null, 16, null);
    }

    @Override // com.tencent.mobileqq.filebrowser.ITBSToolApi
    public void startWatchTopActivity(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        ITbsToolHost toolHost = TbsToolEntrance.getInstance().getToolHost();
        if (!(toolHost instanceof TBSToolInjector)) {
            return;
        }
        ((TBSToolInjector) toolHost).c(activity);
    }

    @Override // com.tencent.mobileqq.filebrowser.ITBSToolApi
    public void stopWatchTopActivity(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        ITbsToolHost toolHost = TbsToolEntrance.getInstance().getToolHost();
        if (!(toolHost instanceof TBSToolInjector)) {
            return;
        }
        ((TBSToolInjector) toolHost).d(activity);
    }

    @Override // com.tencent.mobileqq.filebrowser.ITBSToolApi
    public void openFile(long sessionId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            TBSToolClientUtils.A(TBSToolClientUtils.f291401a, sessionId, null, 2, null);
        } else {
            iPatchRedirector.redirect((short) 15, (Object) this, sessionId);
        }
    }
}
