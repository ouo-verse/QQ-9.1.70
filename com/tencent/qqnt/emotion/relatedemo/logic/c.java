package com.tencent.qqnt.emotion.relatedemo.logic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.relatedemo.RelatedEmotionMsgIntent;
import com.tencent.qqnt.emotion.relatedemo.d;
import com.tencent.qqnt.msg.data.g;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ww3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/logic/c;", "Lcom/tencent/qqnt/emotion/relatedemo/d;", "Lww3/a$a;", "", "path", "", QCircleLpReportDc010001.KEY_SUBTYPE, "textSummary", "Lcom/tencent/qqnt/msg/data/g;", "picExtBizInfo", "", "b", "Lcom/tencent/aio/api/runtime/a;", "context", "Lww3/a;", "panelProvider", "c", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "a", "hidePanel", "Lww3/a;", "mPanelProvider", "Lcom/tencent/aio/api/runtime/a;", "mContext", "<init>", "()V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c implements d, a.InterfaceC11515a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ww3.a mPanelProvider;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mContext;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.emotion.relatedemo.d
    public void a(@NotNull com.tencent.aio.data.msglist.a msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        ww3.a aVar = this.mPanelProvider;
        if (aVar != null) {
            com.tencent.aio.api.runtime.a aVar2 = this.mContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar2 = null;
            }
            aVar.a(aVar2, msgItem);
        }
        ww3.a aVar3 = this.mPanelProvider;
        if (aVar3 != null) {
            aVar3.c(this);
        }
        ww3.a aVar4 = this.mPanelProvider;
        if (aVar4 != null) {
            aVar4.onShow();
        }
    }

    @Override // ww3.a.InterfaceC11515a
    public void b(@NotNull String path, int subType, @Nullable String textSummary, @Nullable g picExtBizInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, path, Integer.valueOf(subType), textSummary, picExtBizInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().h(new RelatedEmotionMsgIntent.SendPicEmotion(path));
    }

    @Override // com.tencent.qqnt.emotion.relatedemo.d
    public void c(@NotNull com.tencent.aio.api.runtime.a context, @NotNull ww3.a panelProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) panelProvider);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(panelProvider, "panelProvider");
        if (QLog.isDevelopLevel()) {
            QLog.i("AIORelatedEmotionPanelProvider", 4, "RelatedEmotionPanelVM: handleInitEmoPanel");
        }
        this.mContext = context;
        this.mPanelProvider = panelProvider;
    }

    @Override // com.tencent.qqnt.emotion.relatedemo.d
    public void hidePanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ww3.a aVar = this.mPanelProvider;
        if (aVar != null) {
            aVar.onDismiss();
        }
    }
}
