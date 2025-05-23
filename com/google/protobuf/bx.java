package com.google.protobuf;

import com.tencent.mobileqq.tianshu.ui.RedTouch;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class bx {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ByteString f35786a;

        a(ByteString byteString) {
            this.f35786a = byteString;
        }

        @Override // com.google.protobuf.bx.c
        public byte a(int i3) {
            return this.f35786a.byteAt(i3);
        }

        @Override // com.google.protobuf.bx.c
        public int size() {
            return this.f35786a.size();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f35787a;

        b(byte[] bArr) {
            this.f35787a = bArr;
        }

        @Override // com.google.protobuf.bx.c
        public byte a(int i3) {
            return this.f35787a[i3];
        }

        @Override // com.google.protobuf.bx.c
        public int size() {
            return this.f35787a.length;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface c {
        byte a(int i3);

        int size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(ByteString byteString) {
        return b(new a(byteString));
    }

    static String b(c cVar) {
        StringBuilder sb5 = new StringBuilder(cVar.size());
        for (int i3 = 0; i3 < cVar.size(); i3++) {
            byte a16 = cVar.a(i3);
            if (a16 != 34) {
                if (a16 != 39) {
                    if (a16 != 92) {
                        switch (a16) {
                            case 7:
                                sb5.append("\\a");
                                break;
                            case 8:
                                sb5.append("\\b");
                                break;
                            case 9:
                                sb5.append("\\t");
                                break;
                            case 10:
                                sb5.append(RedTouch.NEWLINE_CHAR);
                                break;
                            case 11:
                                sb5.append("\\v");
                                break;
                            case 12:
                                sb5.append("\\f");
                                break;
                            case 13:
                                sb5.append("\\r");
                                break;
                            default:
                                if (a16 >= 32 && a16 <= 126) {
                                    sb5.append((char) a16);
                                    break;
                                } else {
                                    sb5.append('\\');
                                    sb5.append((char) (((a16 >>> 6) & 3) + 48));
                                    sb5.append((char) (((a16 >>> 3) & 7) + 48));
                                    sb5.append((char) ((a16 & 7) + 48));
                                    break;
                                }
                                break;
                        }
                    } else {
                        sb5.append("\\\\");
                    }
                } else {
                    sb5.append("\\'");
                }
            } else {
                sb5.append("\\\"");
            }
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(byte[] bArr) {
        return b(new b(bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(String str) {
        return a(ByteString.copyFromUtf8(str));
    }
}
