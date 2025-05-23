package com.tencent.qqnt.emotion.relatedemo.logic;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.relatedemo.NTRelatedEmotionSearchResult;
import com.tencent.qqnt.emotion.relatedemo.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0001\u0013\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/logic/b;", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "curType", "", "c", "b", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "a", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "getApp", "()Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Lcom/tencent/qqnt/emotion/relatedemo/m;", "Lcom/tencent/qqnt/emotion/relatedemo/m;", "()Lcom/tencent/qqnt/emotion/relatedemo/m;", "callback", "com/tencent/qqnt/emotion/relatedemo/logic/b$a", "Lcom/tencent/qqnt/emotion/relatedemo/logic/b$a;", "observer", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Lcom/tencent/qqnt/emotion/relatedemo/m;)V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BaseQQAppInterface app;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final m callback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a observer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/emotion/relatedemo/logic/b$a", "Lcom/tencent/qqnt/emotion/relatedemo/logic/a;", "Lcom/tencent/qqnt/emotion/relatedemo/NTRelatedEmotionSearchResult;", "result", "", "b", "", "errorCode", "a", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a extends com.tencent.qqnt.emotion.relatedemo.logic.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.qqnt.emotion.relatedemo.logic.a
        public void a(int errorCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode);
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("AIORelatedEmotionPanelProvider", 4, "NTRelatedEmoticonManager onSearchRelatedEmoError");
            }
            b.this.a().onError(errorCode);
        }

        @Override // com.tencent.qqnt.emotion.relatedemo.logic.a
        public void b(@NotNull NTRelatedEmotionSearchResult result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(result, "result");
            if (QLog.isDevelopLevel()) {
                QLog.i("AIORelatedEmotionPanelProvider", 4, "NTRelatedEmoticonManager onSearchRelatedEmoResponse");
            }
            b.this.a().a(result);
        }
    }

    public b(@NotNull BaseQQAppInterface app, @NotNull m callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app, (Object) callback);
            return;
        }
        this.app = app;
        this.callback = callback;
        a aVar = new a();
        this.observer = aVar;
        app.addObserver(aVar);
    }

    @NotNull
    public final m a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (m) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.callback;
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.app.removeObserver(this.observer);
        }
    }

    public final void c(@NotNull AIOMsgItem msgItem, int curType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgItem, curType);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (QLog.isDevelopLevel()) {
            QLog.i("AIORelatedEmotionPanelProvider", 4, "NTRelatedEmoticonManager searchRelatedEmoticon");
        }
        BusinessHandler businessHandler = this.app.getBusinessHandler(NTRelatedEmoSearchHandler.INSTANCE.a());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.qqnt.emotion.relatedemo.logic.NTRelatedEmoSearchHandler");
        ((NTRelatedEmoSearchHandler) businessHandler).J2(msgItem, curType);
    }
}
