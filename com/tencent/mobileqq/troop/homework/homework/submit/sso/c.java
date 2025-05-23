package com.tencent.mobileqq.troop.homework.homework.submit.sso;

import com.google.protobuf.CodedOutputStream;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u00a8\u0006\b"}, d2 = {"Lcom/google/protobuf/CodedOutputStream;", "", "fieldNumber", "Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/h;", "value", "", "d", "c", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int c(int i3, h hVar) {
        int serializedSize = hVar.getSerializedSize();
        return CodedOutputStream.X(i3) + CodedOutputStream.Z(serializedSize) + serializedSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(CodedOutputStream codedOutputStream, int i3, h hVar) {
        codedOutputStream.a1(i3, 2);
        codedOutputStream.c1(hVar.getSerializedSize());
        hVar.writeTo(codedOutputStream);
    }
}
