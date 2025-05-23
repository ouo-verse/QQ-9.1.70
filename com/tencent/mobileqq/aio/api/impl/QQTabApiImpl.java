package com.tencent.mobileqq.aio.api.impl;

import com.tencent.mobileqq.aio.api.IQQTabApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/api/impl/QQTabApiImpl;", "Lcom/tencent/mobileqq/aio/api/IQQTabApi;", "", ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "", "needReport", "Lcom/tencent/mobileqq/utils/abtest/ExpEntityInfo;", "getExpEntityInner", "Lcom/tencent/mobileqq/aio/api/IQQTabApi$a;", "getExpEntity", "", "cached", "Ljava/util/Map;", "<init>", "()V", "Companion", "a", "nt-adapter-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class QQTabApiImpl implements IQQTabApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "QQTabApiImpl";

    @NotNull
    private final Map<String, ExpEntityInfo> cached;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/api/impl/QQTabApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "nt-adapter-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.api.impl.QQTabApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/api/impl/QQTabApiImpl$b", "Lcom/tencent/mobileqq/aio/api/IQQTabApi$a;", "", "experimentGroupId", "", "isExperiment", "nt-adapter-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements IQQTabApi.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExpEntityInfo f188186a;

        b(ExpEntityInfo expEntityInfo) {
            this.f188186a = expEntityInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) expEntityInfo);
            }
        }

        @Override // com.tencent.mobileqq.aio.api.IQQTabApi.a
        public boolean isExperiment(@NotNull String experimentGroupId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) experimentGroupId)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(experimentGroupId, "experimentGroupId");
            return this.f188186a.isExperiment(experimentGroupId);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21874);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQTabApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.cached = new LinkedHashMap();
        }
    }

    private final ExpEntityInfo getExpEntityInner(String expName, boolean needReport) {
        String str = expName + "_" + ABTestController.getInstance().getLoginAccountUin();
        ExpEntityInfo expEntityInfo = this.cached.get(str);
        if (expEntityInfo != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getExpEntityInner from cached, key=" + str);
            }
            return expEntityInfo;
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(expName);
        if (needReport) {
            expEntity.reportExpExposure();
        }
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEnti\u2026)\n            }\n        }");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getExpEntityInner from tab, key=" + str + ", entityInvalid=" + expEntity.isExpInvalid());
        }
        if (!expEntity.isExpInvalid()) {
            this.cached.put(str, expEntity);
        }
        return expEntity;
    }

    @Override // com.tencent.mobileqq.aio.api.IQQTabApi
    @NotNull
    public IQQTabApi.a getExpEntity(@NotNull String expName, boolean needReport) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IQQTabApi.a) iPatchRedirector.redirect((short) 2, this, expName, Boolean.valueOf(needReport));
        }
        Intrinsics.checkNotNullParameter(expName, "expName");
        return new b(getExpEntityInner(expName, needReport));
    }
}
