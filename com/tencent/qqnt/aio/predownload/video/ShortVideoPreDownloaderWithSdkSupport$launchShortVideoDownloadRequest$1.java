package com.tencent.qqnt.aio.predownload.video;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "url", "resultVideoCodecFormat", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
final class ShortVideoPreDownloaderWithSdkSupport$launchShortVideoDownloadRequest$1 extends Lambda implements Function4<Integer, String, String, Integer, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ com.tencent.qqnt.aio.predownload.video.req.a $videoDownloadReq;
    final /* synthetic */ ShortVideoPreDownloaderWithSdkSupport this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortVideoPreDownloaderWithSdkSupport$launchShortVideoDownloadRequest$1(ShortVideoPreDownloaderWithSdkSupport shortVideoPreDownloaderWithSdkSupport, com.tencent.qqnt.aio.predownload.video.req.a aVar) {
        super(4);
        this.this$0 = shortVideoPreDownloaderWithSdkSupport;
        this.$videoDownloadReq = aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) shortVideoPreDownloaderWithSdkSupport, (Object) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ShortVideoPreDownloaderWithSdkSupport this$0, com.tencent.qqnt.aio.predownload.video.req.a videoDownloadReq, int i3, String errMsg, String str, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(videoDownloadReq, "$videoDownloadReq");
        Intrinsics.checkNotNullParameter(errMsg, "$errMsg");
        this$0.M(videoDownloadReq, i3, errMsg, str, i16);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, String str2, Integer num2) {
        invoke(num.intValue(), str, str2, num2.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final int i3, @NotNull final String errMsg, @Nullable final String str, final int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), errMsg, str, Integer.valueOf(i16));
            return;
        }
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        final ShortVideoPreDownloaderWithSdkSupport shortVideoPreDownloaderWithSdkSupport = this.this$0;
        final com.tencent.qqnt.aio.predownload.video.req.a aVar = this.$videoDownloadReq;
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.qqnt.aio.predownload.video.h
            @Override // java.lang.Runnable
            public final void run() {
                ShortVideoPreDownloaderWithSdkSupport$launchShortVideoDownloadRequest$1.b(ShortVideoPreDownloaderWithSdkSupport.this, aVar, i3, errMsg, str, i16);
            }
        }, 5, null, false);
    }
}
