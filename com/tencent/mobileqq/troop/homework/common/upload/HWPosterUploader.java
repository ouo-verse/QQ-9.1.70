package com.tencent.mobileqq.troop.homework.common.upload;

import android.os.SystemClock;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.upload.c;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.UploadOrDownloadState;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.VideoItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.g;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0011Be\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\u0006\u0010 \u001a\u00020\u001b\u0012!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\"\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00070!\u0012!\u0010(\u001a\u001d\u0012\u0013\u0012\u00110\"\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00070!\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\"\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0016R\u0017\u0010\u0015\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR/\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\"\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00070!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R/\u0010(\u001a\u001d\u0012\u0013\u0012\u00110\"\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00070!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010&R0\u0010,\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020)j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0002`*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010.\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/upload/HWPosterUploader;", "", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/VideoItem;", "Lcom/tencent/mobileqq/troop/homework/common/upload/c;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "f", "", "g", "e", "", "localPath", "httpUrl", "onSuccess", "", "errorCode", "errorMsg", "a", "I", "getCmd", "()I", "cmd", "b", "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "troopUin", "Lkotlinx/coroutines/CoroutineScope;", "c", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", "Lkotlin/ParameterName;", "name", "d", "Lkotlin/jvm/functions/Function1;", "startUploadVideo", "updateCallback", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "posterToVideoPath", "Lcom/tencent/mobileqq/troop/homework/common/upload/HWLocalPathUploader;", "Lcom/tencent/mobileqq/troop/homework/common/upload/HWLocalPathUploader;", "posterUploader", "<init>", "(ILjava/lang/String;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", h.F, "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWPosterUploader implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int cmd;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<BaseItem, Unit> startUploadVideo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<BaseItem, Unit> updateCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, VideoItem> posterToVideoPath;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HWLocalPathUploader posterUploader;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/upload/HWPosterUploader$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.upload.HWPosterUploader$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46041);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWPosterUploader(int i3, @NotNull String troopUin, @NotNull CoroutineScope scope, @NotNull Function1<? super BaseItem, Unit> startUploadVideo, @NotNull Function1<? super BaseItem, Unit> updateCallback) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(startUploadVideo, "startUploadVideo");
        Intrinsics.checkNotNullParameter(updateCallback, "updateCallback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), troopUin, scope, startUploadVideo, updateCallback);
            return;
        }
        this.cmd = i3;
        this.troopUin = troopUin;
        this.scope = scope;
        this.startUploadVideo = startUploadVideo;
        this.updateCallback = updateCallback;
        this.posterToVideoPath = new HashMap<>();
        this.posterUploader = new HWLocalPathUploader(i3, troopUin, this);
    }

    @Override // com.tencent.mobileqq.troop.homework.common.upload.c
    public void a(@NotNull String localPath, int errorCode, @Nullable String errorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, localPath, Integer.valueOf(errorCode), errorMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        VideoItem remove = this.posterToVideoPath.remove(localPath);
        if (remove != null) {
            QLog.i("HW.HWNoticePosterUploader", 1, "onError:" + localPath);
            remove.setState(UploadOrDownloadState.UPLOAD_ERR);
            this.updateCallback.invoke(remove);
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.posterUploader.i();
            this.posterToVideoPath.clear();
        }
    }

    public boolean f(@NotNull VideoItem item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        String localPath = item.getLocalPath();
        boolean z16 = false;
        if (localPath == null) {
            return false;
        }
        if (this.posterToVideoPath.containsKey(localPath)) {
            QLog.i("HW.HWNoticePosterUploader", 1, "startUpload ignore, containsKey:" + localPath);
            return false;
        }
        item.setStartMillis(SystemClock.elapsedRealtime());
        item.setState(UploadOrDownloadState.UPLOADING);
        String posterLocalPath = item.getPosterLocalPath();
        if (posterLocalPath == null || posterLocalPath.length() == 0) {
            z16 = true;
        }
        if (z16) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getIO(), null, new HWPosterUploader$startUpload$2(item, this, null), 2, null);
            return true;
        }
        String posterLocalPath2 = item.getPosterLocalPath();
        if (posterLocalPath2 != null) {
            this.posterToVideoPath.put(posterLocalPath2, item);
        }
        this.posterUploader.o(new g(item.getPosterLocalPath(), item));
        return true;
    }

    public void g(@NotNull VideoItem item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        this.posterUploader.p(new g(item.getPosterLocalPath(), item));
        HashMap<String, VideoItem> hashMap = this.posterToVideoPath;
        VideoItem videoItem = (VideoItem) TypeIntrinsics.asMutableMap(hashMap).remove(item.getPosterLocalPath());
        if (videoItem != null) {
            this.posterUploader.p(new g(videoItem.getLocalPath(), videoItem));
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.upload.c
    public void onProgress(@NotNull String str, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Float.valueOf(f16));
        } else {
            c.a.a(this, str, f16);
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
        VideoItem remove = this.posterToVideoPath.remove(localPath);
        if (remove != null) {
            QLog.i("HW.HWNoticePosterUploader", 1, "onSuccess:" + localPath + ",httpUrl:" + httpUrl);
            remove.setPosterHttpUrl(httpUrl);
            this.startUploadVideo.invoke(remove);
            this.updateCallback.invoke(remove);
        }
    }
}
