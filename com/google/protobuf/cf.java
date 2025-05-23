package com.google.protobuf;

import com.google.protobuf.cc;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class cf extends cb<cc, cc.b> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public cc g(Object obj) {
        return ((GeneratedMessageV3) obj).unknownFields;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public int h(cc ccVar) {
        return ccVar.getSerializedSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public int i(cc ccVar) {
        return ccVar.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public cc k(cc ccVar, cc ccVar2) {
        return ccVar.toBuilder().p(ccVar2).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public cc.b n() {
        return cc.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void o(Object obj, cc.b bVar) {
        ((GeneratedMessageV3) obj).unknownFields = bVar.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void p(Object obj, cc ccVar) {
        ((GeneratedMessageV3) obj).unknownFields = ccVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public cc r(cc.b bVar) {
        return bVar.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void s(cc ccVar, Writer writer) throws IOException {
        ccVar.m(writer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void t(cc ccVar, Writer writer) throws IOException {
        ccVar.n(writer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    public boolean q(bn bnVar) {
        return bnVar.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(cc.b bVar, int i3, int i16) {
        bVar.j(i3, cc.c.t().b(i16).g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void b(cc.b bVar, int i3, long j3) {
        bVar.j(i3, cc.c.t().c(j3).g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void c(cc.b bVar, int i3, cc ccVar) {
        bVar.j(i3, cc.c.t().d(ccVar).g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void d(cc.b bVar, int i3, ByteString byteString) {
        bVar.j(i3, cc.c.t().e(byteString).g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void e(cc.b bVar, int i3, long j3) {
        bVar.j(i3, cc.c.t().f(j3).g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public cc.b f(Object obj) {
        return ((GeneratedMessageV3) obj).unknownFields.toBuilder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    public void j(Object obj) {
    }
}
