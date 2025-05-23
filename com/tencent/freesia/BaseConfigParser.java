package com.tencent.freesia;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 &*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001&B\u0007\u00a2\u0006\u0004\b%\u0010\"J%\u0010\t\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0007H&\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010 \u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00018\u0000H\u0014\u00a2\u0006\u0004\b \u0010\u001fJ\u000f\u0010!\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b#\u0010\u0018J\u000f\u0010$\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b$\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/freesia/IConfigData;", "T", "Lcom/tencent/freesia/ConfigParser;", "", "uin", VipFunCallConstants.KEY_GROUP, "", "content", "doParse", "(Ljava/lang/String;Ljava/lang/String;[B)Lcom/tencent/freesia/IConfigData;", "parse", "([B)Lcom/tencent/freesia/IConfigData;", "", "isAccountRelated", "()Z", "defaultConfig", "()Lcom/tencent/freesia/IConfigData;", "version", "", "onSend", "(Ljava/lang/String;)V", "success", "onReceive", "(Z)V", "Lcom/tencent/freesia/NetworkResult;", "result", "onReceiveNotUpdate", "(Lcom/tencent/freesia/NetworkResult;)V", DownloadInfo.spKey_Config, "onConfigUpdate", "(Lcom/tencent/freesia/IConfigData;)V", "doOnConfigUpdate", "onRemoved", "()V", "onCdnDownload", "onCdnNotUpdate", "<init>", "Companion", "unitedconfig-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public abstract class BaseConfigParser<T extends IConfigData> implements ConfigParser {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final String TAG = "BaseConfigParser";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/freesia/BaseConfigParser$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "unitedconfig-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11728);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public BaseConfigParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.freesia.ConfigParser
    @NotNull
    public abstract T defaultConfig();

    public void doOnConfigUpdate(@Nullable T config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) config);
        }
    }

    @Override // com.tencent.freesia.ConfigParser
    @NotNull
    public final T doParse(@NotNull String uin, @NotNull String group, @NotNull byte[] content) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, this, uin, group, content);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            return parse(content);
        } catch (Throwable th5) {
            ILogger logger = UnitedConfig.INSTANCE.getLOGGER();
            if (logger != null) {
                logger.e(TAG, "parse error: " + Arrays.toString(th5.getStackTrace()));
            }
            ReportBridge a16 = c.a();
            if (a16 != null) {
                ReportType reportType = ReportType.PARSE_FAILED;
                String message = th5.getMessage();
                if (message != null) {
                    bArr = message.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bArr, "(this as java.lang.String).getBytes(charset)");
                } else {
                    bArr = null;
                }
                a16.report(uin, reportType, group, bArr);
            }
            return defaultConfig();
        }
    }

    @Override // com.tencent.freesia.ConfigParser
    public boolean isAccountRelated() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.freesia.ConfigParser
    public void onCdnDownload(boolean success) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, success);
        }
    }

    @Override // com.tencent.freesia.ConfigParser
    public void onCdnNotUpdate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.freesia.ConfigParser
    public final void onConfigUpdate(@Nullable IConfigData config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) config);
        } else {
            doOnConfigUpdate(config);
        }
    }

    @Override // com.tencent.freesia.ConfigParser
    public void onReceive(boolean success) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, success);
        }
    }

    @Override // com.tencent.freesia.ConfigParser
    public void onReceiveNotUpdate(@NotNull NetworkResult result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(result, "result");
        }
    }

    @Override // com.tencent.freesia.ConfigParser
    public void onRemoved() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    @Override // com.tencent.freesia.ConfigParser
    public void onSend(@NotNull String version) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) version);
        } else {
            Intrinsics.checkNotNullParameter(version, "version");
        }
    }

    @NotNull
    public abstract T parse(@NotNull byte[] content);
}
