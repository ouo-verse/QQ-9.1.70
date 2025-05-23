package com.tencent.mobileqq.injector;

import com.tencent.guild.api.video.IGuildVideoApi;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/injector/m;", "Lcom/tencent/qqnt/msg/c;", "", "sourcePath", "b", "thumbFileName", "format", "a", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class m implements com.tencent.qqnt.msg.c {
    static IPatchRedirector $redirector_;

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.msg.c
    @NotNull
    public String a(@NotNull String thumbFileName, @NotNull String format) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) thumbFileName, (Object) format);
        }
        Intrinsics.checkNotNullParameter(thumbFileName, "thumbFileName");
        Intrinsics.checkNotNullParameter(format, "format");
        return ((IGuildVideoApi) QRoute.api(IGuildVideoApi.class)).getShortVideoThumbPicPath(thumbFileName, format);
    }

    @Override // com.tencent.qqnt.msg.c
    @NotNull
    public String b(@NotNull String sourcePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) sourcePath);
        }
        Intrinsics.checkNotNullParameter(sourcePath, "sourcePath");
        CompressInfo compressInfo = new CompressInfo(sourcePath, 0);
        ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
        String str = compressInfo.H;
        if (str == null) {
            return "";
        }
        return str;
    }
}
