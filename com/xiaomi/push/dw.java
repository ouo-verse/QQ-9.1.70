package com.xiaomi.push;

import java.net.UnknownHostException;

/* compiled from: P */
/* loaded from: classes28.dex */
final class dw {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        ei f388627a;

        /* renamed from: b, reason: collision with root package name */
        String f388628b;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Throwable] */
    public static a a(Exception exc) {
        b(exc);
        boolean z16 = exc instanceof fi;
        Exception exc2 = exc;
        if (z16) {
            fi fiVar = (fi) exc;
            exc2 = exc;
            if (fiVar.a() != null) {
                exc2 = fiVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + ":" + message;
        int a16 = er.a(exc2);
        if (a16 != 0) {
            aVar.f388627a = ei.a(ei.GSLB_REQUEST_SUCCESS.a() + a16);
        }
        if (aVar.f388627a == null) {
            aVar.f388627a = ei.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.f388627a == ei.GSLB_TCP_ERR_OTHER) {
            aVar.f388628b = str;
        }
        return aVar;
    }

    private static void b(Exception exc) {
        exc.getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Throwable] */
    public static a c(Exception exc) {
        Throwable cause;
        b(exc);
        boolean z16 = exc instanceof fi;
        Exception exc2 = exc;
        if (z16) {
            fi fiVar = (fi) exc;
            exc2 = exc;
            if (fiVar.a() != null) {
                exc2 = fiVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a16 = er.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a16 != 0) {
            ei a17 = ei.a(ei.CONN_SUCCESS.a() + a16);
            aVar.f388627a = a17;
            if (a17 == ei.CONN_BOSH_ERR && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                aVar.f388627a = ei.CONN_BOSH_UNKNOWNHOST;
            }
        } else {
            aVar.f388627a = ei.CONN_XMPP_ERR;
        }
        ei eiVar = aVar.f388627a;
        if (eiVar == ei.CONN_TCP_ERR_OTHER || eiVar == ei.CONN_XMPP_ERR || eiVar == ei.CONN_BOSH_ERR) {
            aVar.f388628b = str;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Throwable] */
    public static a d(Exception exc) {
        b(exc);
        boolean z16 = exc instanceof fi;
        Exception exc2 = exc;
        if (z16) {
            fi fiVar = (fi) exc;
            exc2 = exc;
            if (fiVar.a() != null) {
                exc2 = fiVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a16 = er.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a16 != 105) {
            if (a16 != 199) {
                if (a16 != 499) {
                    if (a16 != 109) {
                        if (a16 != 110) {
                            aVar.f388627a = ei.BIND_XMPP_ERR;
                        } else {
                            aVar.f388627a = ei.BIND_TCP_BROKEN_PIPE;
                        }
                    } else {
                        aVar.f388627a = ei.BIND_TCP_CONNRESET;
                    }
                } else {
                    aVar.f388627a = ei.BIND_BOSH_ERR;
                    if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                        aVar.f388627a = ei.BIND_BOSH_ITEM_NOT_FOUND;
                    }
                }
            } else {
                aVar.f388627a = ei.BIND_TCP_ERR;
            }
        } else {
            aVar.f388627a = ei.BIND_TCP_READ_TIMEOUT;
        }
        ei eiVar = aVar.f388627a;
        if (eiVar == ei.BIND_TCP_ERR || eiVar == ei.BIND_XMPP_ERR || eiVar == ei.BIND_BOSH_ERR) {
            aVar.f388628b = str;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Throwable] */
    public static a e(Exception exc) {
        b(exc);
        boolean z16 = exc instanceof fi;
        Exception exc2 = exc;
        if (z16) {
            fi fiVar = (fi) exc;
            exc2 = exc;
            if (fiVar.a() != null) {
                exc2 = fiVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        int a16 = er.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a16 != 105) {
            if (a16 != 199) {
                if (a16 != 499) {
                    if (a16 != 109) {
                        if (a16 != 110) {
                            aVar.f388627a = ei.CHANNEL_XMPPEXCEPTION;
                        } else {
                            aVar.f388627a = ei.CHANNEL_TCP_BROKEN_PIPE;
                        }
                    } else {
                        aVar.f388627a = ei.CHANNEL_TCP_CONNRESET;
                    }
                } else {
                    aVar.f388627a = ei.CHANNEL_BOSH_EXCEPTION;
                    if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                        aVar.f388627a = ei.CHANNEL_BOSH_ITEMNOTFIND;
                    }
                }
            } else {
                aVar.f388627a = ei.CHANNEL_TCP_ERR;
            }
        } else {
            aVar.f388627a = ei.CHANNEL_TCP_READTIMEOUT;
        }
        ei eiVar = aVar.f388627a;
        if (eiVar == ei.CHANNEL_TCP_ERR || eiVar == ei.CHANNEL_XMPPEXCEPTION || eiVar == ei.CHANNEL_BOSH_EXCEPTION) {
            aVar.f388628b = str;
        }
        return aVar;
    }
}
