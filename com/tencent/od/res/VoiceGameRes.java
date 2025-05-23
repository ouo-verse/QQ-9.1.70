package com.tencent.od.res;

import android.content.Context;
import android.net.Uri;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.timi.game.api.remoteres.BizId;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ul3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u001b\u0010\u000b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/od/res/VoiceGameRes;", "", "", "b", "a", "Ljava/lang/String;", "localResPath", "remoteUrl", "c", "Lkotlin/Lazy;", "()Ljava/lang/String;", "res", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qq-live-od-adapter-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class VoiceGameRes {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String localResPath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String remoteUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy res;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VoiceGameRes(@NotNull String localResPath) {
        this(localResPath, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(localResPath, "localResPath");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) localResPath);
    }

    private final String c() {
        return (String) this.res.getValue();
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return c();
    }

    @JvmOverloads
    public VoiceGameRes(@NotNull String localResPath, @NotNull String remoteUrl) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(localResPath, "localResPath");
        Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) localResPath, (Object) remoteUrl);
            return;
        }
        this.localResPath = localResPath;
        this.remoteUrl = remoteUrl;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.od.res.VoiceGameRes$res$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VoiceGameRes.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Context d16 = b.d();
                Intrinsics.checkNotNullExpressionValue(d16, "getContext()");
                BizId bizId = BizId.VOICE_GAME;
                String md5 = a.a().getMd5();
                str = VoiceGameRes.this.localResPath;
                String uri = Uri.fromFile(new File(rf4.a.c(d16, bizId, md5, str))).toString();
                Intrinsics.checkNotNullExpressionValue(uri, "fromFile(File(fullPath)).toString()");
                return uri;
            }
        });
        this.res = lazy;
    }

    public /* synthetic */ VoiceGameRes(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? "" : str2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
