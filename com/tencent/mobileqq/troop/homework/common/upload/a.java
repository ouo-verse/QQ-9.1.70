package com.tencent.mobileqq.troop.homework.common.upload;

import android.os.SystemClock;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.UploadOrDownloadState;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.g;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0014B_\u0012\u0006\u0010\u0018\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\n\u0012!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00070\u001d\u0012#\u0010\"\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00070\u001d\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\"\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0016R\u0017\u0010\u0018\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR/\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00070\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010 R1\u0010\"\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00070\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010 R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R0\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020'j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0002`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/upload/a;", "", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", "Lcom/tencent/mobileqq/troop/homework/common/upload/c;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "c", "", "d", "b", "", "localPath", "", "progress", "onProgress", "httpUrl", "onSuccess", "", "errorCode", "errorMsg", "a", "I", "getCmd", "()I", "cmd", "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "troopUin", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlin/jvm/functions/Function1;", "progressCallback", "statusCallback", "Lcom/tencent/mobileqq/troop/homework/common/upload/HWLocalPathUploader;", "e", "Lcom/tencent/mobileqq/troop/homework/common/upload/HWLocalPathUploader;", "pathUploader", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "f", "Ljava/util/HashMap;", "pathToItem", "<init>", "(ILjava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "g", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int cmd;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<BaseItem, Unit> progressCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<BaseItem, Unit> statusCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HWLocalPathUploader pathUploader;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, BaseItem> pathToItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/upload/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.upload.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46013);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(int i3, @NotNull String troopUin, @NotNull Function1<? super BaseItem, Unit> progressCallback, @NotNull Function1<? super BaseItem, Unit> statusCallback) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(progressCallback, "progressCallback");
        Intrinsics.checkNotNullParameter(statusCallback, "statusCallback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), troopUin, progressCallback, statusCallback);
            return;
        }
        this.cmd = i3;
        this.troopUin = troopUin;
        this.progressCallback = progressCallback;
        this.statusCallback = statusCallback;
        this.pathUploader = new HWLocalPathUploader(i3, troopUin, this);
        this.pathToItem = new HashMap<>();
    }

    @Override // com.tencent.mobileqq.troop.homework.common.upload.c
    public void a(@NotNull String localPath, int errorCode, @Nullable String errorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, localPath, Integer.valueOf(errorCode), errorMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        BaseItem remove = this.pathToItem.remove(localPath);
        if (remove != null) {
            remove.setState(UploadOrDownloadState.UPLOAD_ERR);
            this.statusCallback.invoke(remove);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.pathUploader.i();
            this.pathToItem.clear();
        }
    }

    public boolean c(@NotNull BaseItem item) {
        String localPath;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        String localPath2 = item.getLocalPath();
        if (localPath2 == null) {
            return false;
        }
        if (this.pathToItem.containsKey(localPath2)) {
            QLog.i("HW.HWItemUploader", 1, "startUpload ignore, containsKey:" + localPath2);
            return false;
        }
        item.setStartMillis(SystemClock.elapsedRealtime());
        boolean o16 = this.pathUploader.o(new g(item.getLocalPath(), item));
        if (o16 && (localPath = item.getLocalPath()) != null) {
            this.pathToItem.put(localPath, item);
        }
        return o16;
    }

    public void d(@NotNull BaseItem item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        String localPath = item.getLocalPath();
        if (localPath == null) {
            return;
        }
        this.pathToItem.remove(localPath);
        this.pathUploader.p(new g(localPath, item));
    }

    @Override // com.tencent.mobileqq.troop.homework.common.upload.c
    public void onProgress(@NotNull String localPath, float progress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, localPath, Float.valueOf(progress));
            return;
        }
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        BaseItem baseItem = this.pathToItem.get(localPath);
        if (baseItem != null) {
            baseItem.setProgress(progress);
            this.progressCallback.invoke(baseItem);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.upload.c
    public void onSuccess(@NotNull String localPath, @NotNull String httpUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) localPath, (Object) httpUrl);
            return;
        }
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        Intrinsics.checkNotNullParameter(httpUrl, "httpUrl");
        BaseItem remove = this.pathToItem.remove(localPath);
        if (remove != null) {
            remove.setHttpUrl(httpUrl);
            remove.setState(UploadOrDownloadState.UPLOAD_SUC);
            QLog.i("HW.HWItemUploader", 1, "onSuccess, localPath:" + localPath);
            this.statusCallback.invoke(remove);
            com.tencent.mobileqq.troop.homework.utils.a.e(0, "\u4e0a\u4f20\u6210\u529f", SystemClock.elapsedRealtime() - remove.getStartMillis(), remove.getFileSize(), remove.getRawSize(), remove.getMediaType(), this.troopUin, remove.getWidth(), remove.getHeight());
        }
    }
}
