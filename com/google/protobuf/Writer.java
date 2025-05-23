package com.google.protobuf;

import com.google.protobuf.am;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public interface Writer {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum FieldOrder {
        ASCENDING,
        DESCENDING
    }

    void A(int i3, List<Integer> list, boolean z16) throws IOException;

    @Deprecated
    void B(int i3) throws IOException;

    void C(int i3, List<?> list, bq bqVar) throws IOException;

    void D(int i3, List<Long> list, boolean z16) throws IOException;

    void E(int i3, Object obj, bq bqVar) throws IOException;

    FieldOrder F();

    void G(int i3, List<Integer> list, boolean z16) throws IOException;

    void H(int i3, int i16) throws IOException;

    void I(int i3, Object obj) throws IOException;

    void J(int i3, long j3) throws IOException;

    @Deprecated
    void K(int i3) throws IOException;

    void L(int i3, List<Long> list, boolean z16) throws IOException;

    void M(int i3, List<Integer> list, boolean z16) throws IOException;

    void N(int i3, List<Double> list, boolean z16) throws IOException;

    void O(int i3, List<String> list) throws IOException;

    void P(int i3, long j3) throws IOException;

    void Q(int i3, List<Integer> list, boolean z16) throws IOException;

    void R(int i3, List<Long> list, boolean z16) throws IOException;

    void S(int i3, Object obj) throws IOException;

    void a(int i3, String str) throws IOException;

    void b(int i3, boolean z16) throws IOException;

    void c(int i3, long j3) throws IOException;

    void d(int i3, float f16) throws IOException;

    void e(int i3, int i16) throws IOException;

    void f(int i3, int i16) throws IOException;

    void g(int i3, double d16) throws IOException;

    void h(int i3, int i16) throws IOException;

    void i(int i3, long j3) throws IOException;

    void j(int i3, int i16) throws IOException;

    @Deprecated
    void k(int i3, List<?> list) throws IOException;

    void l(int i3, List<Integer> list, boolean z16) throws IOException;

    void m(int i3, ByteString byteString) throws IOException;

    void n(int i3, long j3) throws IOException;

    void o(int i3, List<Long> list, boolean z16) throws IOException;

    void p(int i3, List<ByteString> list) throws IOException;

    @Deprecated
    void q(int i3, Object obj, bq bqVar) throws IOException;

    @Deprecated
    void r(int i3, List<?> list, bq bqVar) throws IOException;

    void s(int i3, List<Float> list, boolean z16) throws IOException;

    void t(int i3, List<Integer> list, boolean z16) throws IOException;

    void u(int i3, List<?> list) throws IOException;

    void v(int i3, int i16) throws IOException;

    <K, V> void w(int i3, am.b<K, V> bVar, Map<K, V> map) throws IOException;

    void x(int i3, List<Boolean> list, boolean z16) throws IOException;

    @Deprecated
    void y(int i3, Object obj) throws IOException;

    void z(int i3, List<Long> list, boolean z16) throws IOException;
}
