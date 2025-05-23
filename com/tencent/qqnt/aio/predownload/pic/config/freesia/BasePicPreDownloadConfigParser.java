package com.tencent.qqnt.aio.predownload.pic.config.freesia;

import android.text.TextUtils;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.UIConfig;
import com.tencent.qqnt.msg.f;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u000eH&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/predownload/pic/config/freesia/BasePicPreDownloadConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/qqnt/aio/predownload/pic/config/freesia/BasePicPreDownloadConfigParser$b;", "", "version", "", "onSend", "", "content", h.F, "c", DownloadInfo.spKey_Config, "d", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/UIConfig;", "g", "<init>", "()V", "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class BasePicPreDownloadConfigParser extends BaseConfigParser<b> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/predownload/pic/config/freesia/BasePicPreDownloadConfigParser$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.predownload.pic.config.freesia.BasePicPreDownloadConfigParser$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/predownload/pic/config/freesia/BasePicPreDownloadConfigParser$b;", "Lcom/tencent/freesia/IConfigData;", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "content", "<init>", "(Ljava/lang/String;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements IConfigData {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String content;

        public b() {
            this(null, 1, 0 == true ? 1 : 0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @Nullable
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.content;
        }

        public b(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.content = str;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        public /* synthetic */ b(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65586);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public BasePicPreDownloadConfigParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(BasePicPreDownloadConfigParser this$0, b bVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IQQNTWrapperSession k3 = f.k();
        if (k3 != null) {
            QLog.d(this$0.f(), 1, "[doOnConfigUpdate] content=" + bVar.a());
            k3.onUIConfigUpdate(this$0.g(), bVar.a());
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new b(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable final b config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) config);
        } else if (config != null && !TextUtils.isEmpty(config.a())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.predownload.pic.config.freesia.a
                @Override // java.lang.Runnable
                public final void run() {
                    BasePicPreDownloadConfigParser.e(BasePicPreDownloadConfigParser.this, config);
                }
            }, 64, null, false);
        } else {
            QLog.e(f(), 1, "[doOnConfigUpdate] empty content!");
        }
    }

    @NotNull
    public abstract String f();

    @NotNull
    public abstract UIConfig g();

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public b parse(@NotNull byte[] content) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) content);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        int i3 = 1;
        if (content.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return new b(null, i3, 0 == true ? 1 : 0);
        }
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return new b(new String(content, UTF_8));
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onSend(@NotNull String version) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) version);
        } else {
            Intrinsics.checkNotNullParameter(version, "version");
        }
    }
}
