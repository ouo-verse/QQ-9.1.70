package com.tencent.mobileqq.aio.utils;

import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.aio.msg.element.AIOElementType;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/utils/z;", "", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$b;", PreDetect.FACE_DETECT, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class z {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final z f194181a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65292);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f194181a = new z();
        }
    }

    z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final MsgElement a(@NotNull AIOElementType.b face2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MsgElement) iPatchRedirector.redirect((short) 2, (Object) this, (Object) face2);
        }
        Intrinsics.checkNotNullParameter(face2, "face");
        FaceElement faceElement = new FaceElement();
        faceElement.faceText = face2.f();
        faceElement.faceType = face2.g();
        if (face2.g() == 4) {
            faceElement.faceIndex = com.tencent.qqnt.msg.a.f359552a.a(Integer.parseInt(face2.m()), face2.e());
            faceElement.imageType = Integer.valueOf(face2.j());
        } else {
            faceElement.faceIndex = face2.e();
        }
        faceElement.randomType = Integer.valueOf(face2.q());
        faceElement.stickerId = face2.u();
        faceElement.stickerType = Integer.valueOf(face2.v());
        faceElement.resultId = face2.r();
        faceElement.sourceType = Integer.valueOf(face2.s());
        faceElement.packId = face2.m();
        faceElement.pokeType = Integer.valueOf(face2.p());
        faceElement.spokeSummary = face2.t();
        faceElement.doubleHit = Integer.valueOf(face2.b());
        faceElement.vaspokeId = Integer.valueOf(face2.w());
        faceElement.vaspokeName = face2.y();
        faceElement.vaspokeMinver = face2.x();
        faceElement.pokeStrength = Integer.valueOf(face2.o());
        faceElement.msgType = Integer.valueOf(face2.k());
        faceElement.faceBubbleCount = Integer.valueOf(face2.c());
        faceElement.oldVersionStr = face2.l();
        faceElement.pokeFlag = Integer.valueOf(face2.n());
        faceElement.chainCount = Integer.valueOf(face2.a());
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 6;
        msgElement.faceElement = faceElement;
        return msgElement;
    }
}
