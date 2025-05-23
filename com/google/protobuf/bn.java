package com.google.protobuf;

import com.google.protobuf.am;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
interface bn {
    int A() throws IOException;

    String B() throws IOException;

    int C() throws IOException;

    void D(List<Boolean> list) throws IOException;

    @Deprecated
    <T> T E(bq<T> bqVar, t tVar) throws IOException;

    <T> void F(List<T> list, bq<T> bqVar, t tVar) throws IOException;

    void G(List<Long> list) throws IOException;

    @Deprecated
    <T> T H(Class<T> cls, t tVar) throws IOException;

    void I(List<Long> list) throws IOException;

    <T> T J(bq<T> bqVar, t tVar) throws IOException;

    long K() throws IOException;

    void L(List<Integer> list) throws IOException;

    void M(List<String> list) throws IOException;

    void N(List<Double> list) throws IOException;

    void O(List<Integer> list) throws IOException;

    void P(List<Integer> list) throws IOException;

    long Q() throws IOException;

    int a() throws IOException;

    long b() throws IOException;

    boolean c() throws IOException;

    String d() throws IOException;

    ByteString e() throws IOException;

    long f() throws IOException;

    int getTag();

    int h() throws IOException;

    void i(List<Integer> list) throws IOException;

    void j(List<Long> list) throws IOException;

    void k(List<Integer> list) throws IOException;

    boolean l();

    boolean m() throws IOException;

    void n(List<String> list) throws IOException;

    <T> T o(Class<T> cls, t tVar) throws IOException;

    int p() throws IOException;

    void q(List<Long> list) throws IOException;

    int r() throws IOException;

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    <K, V> void s(Map<K, V> map, am.b<K, V> bVar, t tVar) throws IOException;

    int t() throws IOException;

    void u(List<Float> list) throws IOException;

    void v(List<ByteString> list) throws IOException;

    long w() throws IOException;

    void x(List<Integer> list) throws IOException;

    @Deprecated
    <T> void y(List<T> list, bq<T> bqVar, t tVar) throws IOException;

    void z(List<Long> list) throws IOException;
}
