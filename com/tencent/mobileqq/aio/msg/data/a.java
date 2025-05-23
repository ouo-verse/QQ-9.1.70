package com.tencent.mobileqq.aio.msg.data;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.aio.msg.element.AIOElementType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010G\u001a\u00020\u0002\u0012\b\b\u0002\u0010H\u001a\u00020\u0002\u00a2\u0006\u0004\bI\u0010JJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0014J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0018J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u001cJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020 J\u0006\u0010#\u001a\u00020 J\u000e\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020$J\u0006\u0010(\u001a\u00020$J\u000e\u0010+\u001a\u00020&2\u0006\u0010*\u001a\u00020)R\u0016\u0010-\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010,R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010,R\"\u00104\u001a\u00020\u00048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00106\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u00105R\u0016\u00108\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00107R\u0016\u0010:\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u00109R\u0016\u0010<\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010;R\u0016\u0010>\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010=R\u0016\u0010@\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010?R\u0016\u0010B\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010AR\u0016\u0010D\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010CR\u0018\u0010F\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010E\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/data/a;", "", "", "a", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$h;", "textElement", "t", "j", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$b;", "faceElement", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$e;", "picElement", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "g", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$i;", "videoElement", "u", "k", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$c;", "fileElement", DomainData.DOMAIN_NAME, "d", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$g;", "replyElement", ReportConstant.COSTREPORT_PREFIX, "i", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$d;", "marketFaceElement", "p", "f", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$f;", "pttElement", "r", h.F, "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$a;", DTConstants.TAG.ELEMENT, "", "l", "b", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$j;", "zPlanActionElement", "v", "I", "mElementType", "mElementId", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$h;", "e", "()Lcom/tencent/qqnt/aio/msg/element/AIOElementType$h;", "o", "(Lcom/tencent/qqnt/aio/msg/element/AIOElementType$h;)V", "mTextElement", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$b;", "mFaceElement", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$e;", "mPicElement", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$c;", "mFileElement", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$i;", "mVideoElement", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$g;", "mReplyElement", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$d;", "mMarketFaceElement", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$f;", "mPttElement", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$a;", "mFaceBubbleElement", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$j;", "mZPlanActionElement", "elementType", "elementId", "<init>", "(II)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int mElementType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int mElementId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public AIOElementType.h mTextElement;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private AIOElementType.b mFaceElement;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AIOElementType.e mPicElement;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private AIOElementType.c mFileElement;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private AIOElementType.i mVideoElement;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private AIOElementType.g mReplyElement;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private AIOElementType.d mMarketFaceElement;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private AIOElementType.f mPttElement;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private AIOElementType.a mFaceBubbleElement;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOElementType.j mZPlanActionElement;

    public a(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mElementType = i3;
            this.mElementId = i16;
        }
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.mElementType;
    }

    @NotNull
    public final AIOElementType.a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (AIOElementType.a) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        AIOElementType.a aVar = this.mFaceBubbleElement;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFaceBubbleElement");
            return null;
        }
        return aVar;
    }

    @NotNull
    public final AIOElementType.b c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (AIOElementType.b) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        AIOElementType.b bVar = this.mFaceElement;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFaceElement");
            return null;
        }
        return bVar;
    }

    @NotNull
    public final AIOElementType.c d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (AIOElementType.c) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        AIOElementType.c cVar = this.mFileElement;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFileElement");
            return null;
        }
        return cVar;
    }

    @NotNull
    public final AIOElementType.h e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIOElementType.h) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        AIOElementType.h hVar = this.mTextElement;
        if (hVar != null) {
            return hVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTextElement");
        return null;
    }

    @NotNull
    public final AIOElementType.d f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (AIOElementType.d) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        AIOElementType.d dVar = this.mMarketFaceElement;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMarketFaceElement");
            return null;
        }
        return dVar;
    }

    @NotNull
    public final AIOElementType.e g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (AIOElementType.e) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        AIOElementType.e eVar = this.mPicElement;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPicElement");
            return null;
        }
        return eVar;
    }

    @NotNull
    public final AIOElementType.f h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (AIOElementType.f) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        AIOElementType.f fVar = this.mPttElement;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPttElement");
            return null;
        }
        return fVar;
    }

    @NotNull
    public final AIOElementType.g i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (AIOElementType.g) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        AIOElementType.g gVar = this.mReplyElement;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyElement");
            return null;
        }
        return gVar;
    }

    @NotNull
    public final AIOElementType.h j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (AIOElementType.h) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return e();
    }

    @NotNull
    public final AIOElementType.i k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (AIOElementType.i) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        AIOElementType.i iVar = this.mVideoElement;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoElement");
            return null;
        }
        return iVar;
    }

    public final void l(@NotNull AIOElementType.a element) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) element);
        } else {
            Intrinsics.checkNotNullParameter(element, "element");
            this.mFaceBubbleElement = element;
        }
    }

    @NotNull
    public final a m(@NotNull AIOElementType.b faceElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (a) iPatchRedirector.redirect((short) 11, (Object) this, (Object) faceElement);
        }
        Intrinsics.checkNotNullParameter(faceElement, "faceElement");
        this.mFaceElement = faceElement;
        return this;
    }

    @NotNull
    public final a n(@NotNull AIOElementType.c fileElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (a) iPatchRedirector.redirect((short) 17, (Object) this, (Object) fileElement);
        }
        Intrinsics.checkNotNullParameter(fileElement, "fileElement");
        this.mFileElement = fileElement;
        return this;
    }

    public final void o(@NotNull AIOElementType.h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) hVar);
        } else {
            Intrinsics.checkNotNullParameter(hVar, "<set-?>");
            this.mTextElement = hVar;
        }
    }

    @NotNull
    public final a p(@NotNull AIOElementType.d marketFaceElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (a) iPatchRedirector.redirect((short) 21, (Object) this, (Object) marketFaceElement);
        }
        Intrinsics.checkNotNullParameter(marketFaceElement, "marketFaceElement");
        this.mMarketFaceElement = marketFaceElement;
        return this;
    }

    @NotNull
    public final a q(@NotNull AIOElementType.e picElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (a) iPatchRedirector.redirect((short) 13, (Object) this, (Object) picElement);
        }
        Intrinsics.checkNotNullParameter(picElement, "picElement");
        this.mPicElement = picElement;
        return this;
    }

    @NotNull
    public final a r(@NotNull AIOElementType.f pttElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (a) iPatchRedirector.redirect((short) 23, (Object) this, (Object) pttElement);
        }
        Intrinsics.checkNotNullParameter(pttElement, "pttElement");
        this.mPttElement = pttElement;
        return this;
    }

    @NotNull
    public final a s(@NotNull AIOElementType.g replyElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (a) iPatchRedirector.redirect((short) 19, (Object) this, (Object) replyElement);
        }
        Intrinsics.checkNotNullParameter(replyElement, "replyElement");
        this.mReplyElement = replyElement;
        return this;
    }

    @NotNull
    public final a t(@NotNull AIOElementType.h textElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (a) iPatchRedirector.redirect((short) 9, (Object) this, (Object) textElement);
        }
        Intrinsics.checkNotNullParameter(textElement, "textElement");
        o(textElement);
        return this;
    }

    @NotNull
    public final a u(@NotNull AIOElementType.i videoElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (a) iPatchRedirector.redirect((short) 15, (Object) this, (Object) videoElement);
        }
        Intrinsics.checkNotNullParameter(videoElement, "videoElement");
        this.mVideoElement = videoElement;
        return this;
    }

    public final void v(@NotNull AIOElementType.j zPlanActionElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) zPlanActionElement);
        } else {
            Intrinsics.checkNotNullParameter(zPlanActionElement, "zPlanActionElement");
            this.mZPlanActionElement = zPlanActionElement;
        }
    }

    public /* synthetic */ a(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i17 & 2) != 0 ? 0 : i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
    }
}
