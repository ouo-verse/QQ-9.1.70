package com.tencent.guild.api.msg.service;

import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sr0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/guild/api/msg/service/m;", "", "Lsr0/a$b;", PreDetect.FACE_DETECT, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "a", "<init>", "()V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f112635a = new m();

    m() {
    }

    @NotNull
    public final MsgElement a(@NotNull a.FaceElement face2) {
        Intrinsics.checkNotNullParameter(face2, "face");
        FaceElement faceElement = new FaceElement();
        faceElement.faceText = face2.getFaceText();
        faceElement.faceType = face2.getFaceType();
        if (face2.getFaceType() == 4) {
            faceElement.faceIndex = com.tencent.qqnt.msg.a.f359552a.a(Integer.parseInt(face2.getPackId()), face2.getFaceIndex());
            faceElement.imageType = Integer.valueOf(face2.getImageType());
        } else {
            faceElement.faceIndex = face2.getFaceIndex();
        }
        faceElement.randomType = Integer.valueOf(face2.getRandomType());
        faceElement.stickerId = face2.getStickerId();
        faceElement.stickerType = Integer.valueOf(face2.getStickerType());
        faceElement.resultId = face2.getResultId();
        faceElement.sourceType = Integer.valueOf(face2.getSourceType());
        faceElement.packId = face2.getPackId();
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 6;
        msgElement.faceElement = faceElement;
        return msgElement;
    }
}
