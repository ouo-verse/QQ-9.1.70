package com.tencent.qqnt.emotion.api.impl;

import com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqnt.emotion.api.IQQSysAndEmojiResApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/emotion/api/impl/QQSysAndEmojiResApiImpl;", "Lcom/tencent/qqnt/emotion/api/IQQSysAndEmojiResApi;", "Loa1/d;", "getSystemAndEmojiConfBean", "Loa1/c;", "getExtAniStickerConfBean", "<init>", "()V", "Companion", "a", "nt-adapter-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class QQSysAndEmojiResApiImpl implements IQQSysAndEmojiResApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "QQSysAndEmojiResApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/emotion/api/impl/QQSysAndEmojiResApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "nt-adapter-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.emotion.api.impl.QQSysAndEmojiResApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21960);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQSysAndEmojiResApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.emotion.api.IQQSysAndEmojiResApi
    @Nullable
    public oa1.c getExtAniStickerConfBean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (oa1.c) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (oa1.c) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101580");
    }

    @Override // com.tencent.qqnt.emotion.api.IQQSysAndEmojiResApi
    @Nullable
    public oa1.d getSystemAndEmojiConfBean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (oa1.d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return QQSysAndEmojiConfProcessor.b();
    }
}
