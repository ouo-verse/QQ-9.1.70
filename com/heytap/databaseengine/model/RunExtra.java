package com.heytap.databaseengine.model;

import androidx.annotation.Keep;
import com.tencent.avcore.jni.codec.NativeCodec;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b5\n\u0002\u0010 \n\u0002\b\u001a\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0003\b\u0095\u0001\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001a\u00103\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001a\u00106\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\u001a\u00109\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\u001a\u0010<\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\u001a\u0010?\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\"\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010CX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\bR\u001a\u0010K\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0006\"\u0004\bM\u0010\bR\"\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010CX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010E\"\u0004\bP\u0010GR\u001a\u0010Q\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0006\"\u0004\bS\u0010\bR\u001a\u0010T\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0006\"\u0004\bV\u0010\bR\"\u0010W\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010CX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010E\"\u0004\bY\u0010GR\u001a\u0010Z\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0006\"\u0004\b\\\u0010\bR\u001a\u0010]\u001a\u00020^X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\"\u0010c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010CX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bd\u0010E\"\u0004\be\u0010GR\u001a\u0010f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0006\"\u0004\bh\u0010\bR\u001a\u0010i\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u0006\"\u0004\bk\u0010\bR\u001a\u0010l\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u0006\"\u0004\bn\u0010\bR\u001a\u0010o\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u0006\"\u0004\bq\u0010\bR\u001a\u0010r\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0006\"\u0004\bt\u0010\bR\u001a\u0010u\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\u0006\"\u0004\bw\u0010\bR\u001a\u0010x\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u0006\"\u0004\bz\u0010\bR\"\u0010{\u001a\n\u0012\u0004\u0012\u00020|\u0018\u00010CX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b}\u0010E\"\u0004\b~\u0010GR\u001c\u0010\u007f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010\u0006\"\u0005\b\u0081\u0001\u0010\bR\u001d\u0010\u0082\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u0006\"\u0005\b\u0084\u0001\u0010\bR\u001d\u0010\u0085\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010\u0006\"\u0005\b\u0087\u0001\u0010\bR\u001d\u0010\u0088\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010\u0006\"\u0005\b\u008a\u0001\u0010\bR\u001d\u0010\u008b\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010\u0006\"\u0005\b\u008d\u0001\u0010\bR\u001d\u0010\u008e\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010\u0006\"\u0005\b\u0090\u0001\u0010\bR%\u0010\u0091\u0001\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010CX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010E\"\u0005\b\u0093\u0001\u0010GR%\u0010\u0094\u0001\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010CX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010E\"\u0005\b\u0096\u0001\u0010GR\u001d\u0010\u0097\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010\u0006\"\u0005\b\u0099\u0001\u0010\bR\"\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u0001X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001d\u0010\u00a0\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a1\u0001\u0010\u0006\"\u0005\b\u00a2\u0001\u0010\bR\u001d\u0010\u00a3\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a4\u0001\u0010\u0006\"\u0005\b\u00a5\u0001\u0010\bR\u001d\u0010\u00a6\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a7\u0001\u0010\u0006\"\u0005\b\u00a8\u0001\u0010\bR\u001d\u0010\u00a9\u0001\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00aa\u0001\u0010\u000f\"\u0005\b\u00ab\u0001\u0010\u0011R\u001d\u0010\u00ac\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ad\u0001\u0010\u0006\"\u0005\b\u00ae\u0001\u0010\bR\u001d\u0010\u00af\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b0\u0001\u0010\u0006\"\u0005\b\u00b1\u0001\u0010\bR\u001d\u0010\u00b2\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b3\u0001\u0010\u0006\"\u0005\b\u00b4\u0001\u0010\bR\u001d\u0010\u00b5\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b6\u0001\u0010\u0006\"\u0005\b\u00b7\u0001\u0010\bR\u001d\u0010\u00b8\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b9\u0001\u0010\u0006\"\u0005\b\u00ba\u0001\u0010\bR%\u0010\u00bb\u0001\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010CX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00bc\u0001\u0010E\"\u0005\b\u00bd\u0001\u0010GR\u001d\u0010\u00be\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00bf\u0001\u0010\u0006\"\u0005\b\u00c0\u0001\u0010\bR\u001d\u0010\u00c1\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c2\u0001\u0010\u0006\"\u0005\b\u00c3\u0001\u0010\bR\u001d\u0010\u00c4\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c5\u0001\u0010\u0006\"\u0005\b\u00c6\u0001\u0010\bR\u001d\u0010\u00c7\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c8\u0001\u0010\u0006\"\u0005\b\u00c9\u0001\u0010\bR\u001d\u0010\u00ca\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00cb\u0001\u0010\u0006\"\u0005\b\u00cc\u0001\u0010\bR\u001d\u0010\u00cd\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ce\u0001\u0010\u0006\"\u0005\b\u00cf\u0001\u0010\bR\u001d\u0010\u00d0\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d1\u0001\u0010\u0006\"\u0005\b\u00d2\u0001\u0010\bR\u001d\u0010\u00d3\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d4\u0001\u0010\u0006\"\u0005\b\u00d5\u0001\u0010\bR\u001d\u0010\u00d6\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d7\u0001\u0010\u0006\"\u0005\b\u00d8\u0001\u0010\bR\"\u0010\u00d9\u0001\u001a\u0005\u0018\u00010\u009b\u0001X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00da\u0001\u0010\u009d\u0001\"\u0006\b\u00db\u0001\u0010\u009f\u0001R\u001d\u0010\u00dc\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00dd\u0001\u0010\u0006\"\u0005\b\u00de\u0001\u0010\bR\u001d\u0010\u00df\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00e0\u0001\u0010\u0006\"\u0005\b\u00e1\u0001\u0010\bR\u001d\u0010\u00e2\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00e3\u0001\u0010\u0006\"\u0005\b\u00e4\u0001\u0010\bR\u001d\u0010\u00e5\u0001\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00e6\u0001\u0010\u000f\"\u0005\b\u00e7\u0001\u0010\u0011R\u001d\u0010\u00e8\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00e9\u0001\u0010\u0006\"\u0005\b\u00ea\u0001\u0010\bR\u001d\u0010\u00eb\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ec\u0001\u0010\u0006\"\u0005\b\u00ed\u0001\u0010\bR\u001d\u0010\u00ee\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ef\u0001\u0010\u0006\"\u0005\b\u00f0\u0001\u0010\bR\u001d\u0010\u00f1\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00f2\u0001\u0010\u0006\"\u0005\b\u00f3\u0001\u0010\bR%\u0010\u00f4\u0001\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010CX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00f5\u0001\u0010E\"\u0005\b\u00f6\u0001\u0010GR\u001d\u0010\u00f7\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00f8\u0001\u0010\u0006\"\u0005\b\u00f9\u0001\u0010\bR\u001d\u0010\u00fa\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00fb\u0001\u0010\u0006\"\u0005\b\u00fc\u0001\u0010\bR\u001d\u0010\u00fd\u0001\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00fe\u0001\u0010\u0006\"\u0005\b\u00ff\u0001\u0010\bR\u001d\u0010\u0080\u0002\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0002\u0010\u0006\"\u0005\b\u0082\u0002\u0010\bR\u001d\u0010\u0083\u0002\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0002\u0010\u0006\"\u0005\b\u0085\u0002\u0010\bR%\u0010\u0086\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010CX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0002\u0010E\"\u0005\b\u0088\u0002\u0010GR%\u0010\u0089\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010CX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0002\u0010E\"\u0005\b\u008b\u0002\u0010GR\u001d\u0010\u008c\u0002\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0002\u0010\u0006\"\u0005\b\u008e\u0002\u0010\bR\u001d\u0010\u008f\u0002\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0002\u0010\u0006\"\u0005\b\u0091\u0002\u0010\bR\u001d\u0010\u0092\u0002\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0002\u0010\u0006\"\u0005\b\u0094\u0002\u0010\bR\u001d\u0010\u0095\u0002\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0002\u0010\u0006\"\u0005\b\u0097\u0002\u0010\bR\u001d\u0010\u0098\u0002\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0002\u0010\u0006\"\u0005\b\u009a\u0002\u0010\bR\u001d\u0010\u009b\u0002\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0002\u0010\u0006\"\u0005\b\u009d\u0002\u0010\bR\u001d\u0010\u009e\u0002\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0002\u0010\u0006\"\u0005\b\u00a0\u0002\u0010\bR\u001d\u0010\u00a1\u0002\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a2\u0002\u0010\u0006\"\u0005\b\u00a3\u0002\u0010\bR\u001d\u0010\u00a4\u0002\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a5\u0002\u0010\u000f\"\u0005\b\u00a6\u0002\u0010\u0011R\u001d\u0010\u00a7\u0002\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a8\u0002\u0010\u0006\"\u0005\b\u00a9\u0002\u0010\bR\u001d\u0010\u00aa\u0002\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ab\u0002\u0010\u0006\"\u0005\b\u00ac\u0002\u0010\bR\u001d\u0010\u00ad\u0002\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ae\u0002\u0010\u0006\"\u0005\b\u00af\u0002\u0010\b\u00a8\u0006\u00b0\u0002"}, d2 = {"Lcom/heytap/databaseengine/model/RunExtra;", "", "()V", "activeDuration", "", "getActiveDuration", "()I", "setActiveDuration", "(I)V", "activeTime", "getActiveTime", "setActiveTime", "adh", "", "getAdh", "()F", "setAdh", "(F)V", "aerobicHrmUpper", "getAerobicHrmUpper", "setAerobicHrmUpper", "altitude", "getAltitude", "setAltitude", "autoRecognize", "getAutoRecognize", "setAutoRecognize", "avgBalance", "getAvgBalance", "setAvgBalance", "avgEllipticalFreq", "getAvgEllipticalFreq", "setAvgEllipticalFreq", "avgPower", "getAvgPower", "setAvgPower", "avgRowingFreq", "getAvgRowingFreq", "setAvgRowingFreq", "avgRunningSpeed", "getAvgRunningSpeed", "setAvgRunningSpeed", "avgSpeed", "getAvgSpeed", "setAvgSpeed", "avgStance", "getAvgStance", "setAvgStance", "avgSwingFreq", "getAvgSwingFreq", "setAvgSwingFreq", "avgVertical", "getAvgVertical", "setAvgVertical", "avgVerticalRatio", "getAvgVerticalRatio", "setAvgVerticalRatio", "backHandNum", "getBackHandNum", "setBackHandNum", "backHandSlice", "getBackHandSlice", "setBackHandSlice", "backHandTopspin", "getBackHandTopspin", "setBackHandTopspin", "badmintonSpeed", "", "getBadmintonSpeed", "()Ljava/util/List;", "setBadmintonSpeed", "(Ljava/util/List;)V", "badmintonSpeedCount", "getBadmintonSpeedCount", "setBadmintonSpeedCount", "barometerStatus", "getBarometerStatus", "setBarometerStatus", "bsBadmintonSpeed", "getBsBadmintonSpeed", "setBsBadmintonSpeed", "bsBadmintonSpeedCount", "getBsBadmintonSpeedCount", "setBsBadmintonSpeedCount", "bsTackLength", "getBsTackLength", "setBsTackLength", "bsTennisSpeed", "getBsTennisSpeed", "setBsTennisSpeed", "bsTennisSpeedCount", "getBsTennisSpeedCount", "setBsTennisSpeedCount", "bsTotalDistance", "", "getBsTotalDistance", "()J", "setBsTotalDistance", "(J)V", "bsTurnsDistance", "getBsTurnsDistance", "setBsTurnsDistance", "count", "getCount", "setCount", "cumulativeDecline", "getCumulativeDecline", "setCumulativeDecline", "dataSource", "getDataSource", "setDataSource", "elevation", "getElevation", "setElevation", "ellipticalTotalNum", "getEllipticalTotalNum", "setEllipticalTotalNum", "fatTime", "getFatTime", "setFatTime", "fitSourceType", "getFitSourceType", "setFitSourceType", "fiveKmPlans", "Lcom/heytap/databaseengine/model/FiveKmPlan;", "getFiveKmPlans", "setFiveKmPlans", "foreHandNum", "getForeHandNum", "setForeHandNum", "foreHandPrecent", "getForeHandPrecent", "setForeHandPrecent", "foreHandSlice", "getForeHandSlice", "setForeHandSlice", "foreHandTopspin", "getForeHandTopspin", "setForeHandTopspin", "gpsVersionInfo", "getGpsVersionInfo", "setGpsVersionInfo", "hrSectionType", "getHrSectionType", "setHrSectionType", "hrZone", "getHrZone", "setHrZone", "kmPace", "getKmPace", "setKmPace", "lap", "getLap", "setLap", "lapDetail", "", "getLapDetail", "()Ljava/lang/String;", "setLapDetail", "(Ljava/lang/String;)V", "limitHrmUpper", "getLimitHrmUpper", "setLimitHrmUpper", "maxEllipticalFreq", "getMaxEllipticalFreq", "setMaxEllipticalFreq", "maxHeartRate", "getMaxHeartRate", "setMaxHeartRate", "maxInclination", "getMaxInclination", "setMaxInclination", "maxRowingFreq", "getMaxRowingFreq", "setMaxRowingFreq", "maxStride", "getMaxStride", "setMaxStride", "maxSwingFreq", "getMaxSwingFreq", "setMaxSwingFreq", "maxSwingSpeed", "getMaxSwingSpeed", "setMaxSwingSpeed", "maxTribble", "getMaxTribble", "setMaxTribble", "milePace", "getMilePace", "setMilePace", "numberOfTurns", "getNumberOfTurns", "setNumberOfTurns", "overHandNum", "getOverHandNum", "setOverHandNum", "poolLength", "getPoolLength", "setPoolLength", "recordGrade", "getRecordGrade", "setRecordGrade", "recoveryTime", "getRecoveryTime", "setRecoveryTime", "reducingFatHrmUpper", "getReducingFatHrmUpper", "setReducingFatHrmUpper", "relativeHeight", "getRelativeHeight", "setRelativeHeight", "rowingTotalNum", "getRowingTotalNum", "setRowingTotalNum", "segmentation", "getSegmentation", "setSegmentation", "skiDetail", "getSkiDetail", "setSkiDetail", "skiDuration", "getSkiDuration", "setSkiDuration", "stamina", "getStamina", "setStamina", "staminaHrmUpper", "getStaminaHrmUpper", "setStaminaHrmUpper", "staminaLevel", "getStaminaLevel", "setStaminaLevel", "stanceBalanceEvaluate", "getStanceBalanceEvaluate", "setStanceBalanceEvaluate", "stanceTimeEvaluate", "getStanceTimeEvaluate", "setStanceTimeEvaluate", NativeCodec.STRIDE, "getStride", "setStride", "tennisServe", "getTennisServe", "setTennisServe", "tennisSpeed", "getTennisSpeed", "setTennisSpeed", "tennisSpeedCount", "getTennisSpeedCount", "setTennisSpeedCount", "totalBatting", "getTotalBatting", "setTotalBatting", "trackLength", "getTrackLength", "setTrackLength", "trackNumber", "getTrackNumber", "setTrackNumber", "trainingEffect", "getTrainingEffect", "setTrainingEffect", "turnsDistance", "getTurnsDistance", "setTurnsDistance", "turnsPace", "getTurnsPace", "setTurnsPace", "underHandNum", "getUnderHandNum", "setUnderHandNum", "vailActive", "getVailActive", "setVailActive", "vailDefense", "getVailDefense", "setVailDefense", "vailErupt", "getVailErupt", "setVailErupt", "vailRivalry", "getVailRivalry", "setVailRivalry", "vailStamina", "getVailStamina", "setVailStamina", "verticalEvaluate", "getVerticalEvaluate", "setVerticalEvaluate", "verticalRatioEvaluate", "getVerticalRatioEvaluate", "setVerticalRatioEvaluate", "vo2max", "getVo2max", "setVo2max", "vo2maxLevel", "getVo2maxLevel", "setVo2maxLevel", "warnUpHrmLower", "getWarnUpHrmLower", "setWarnUpHrmLower", "warnUpHrmUpper", "getWarnUpHrmUpper", "setWarnUpHrmUpper", "heytap_health_sdk_v2.1.5_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RunExtra {
    private int activeDuration;
    private int activeTime;
    private float adh;
    private int aerobicHrmUpper;
    private int autoRecognize;
    private int avgEllipticalFreq;
    private int avgPower;
    private int avgRowingFreq;
    private int avgRunningSpeed;
    private int avgSpeed;
    private int avgStance;
    private int avgSwingFreq;
    private int avgVertical;
    private int avgVerticalRatio;
    private int backHandNum;
    private int backHandSlice;
    private int backHandTopspin;

    @Nullable
    private List<Integer> badmintonSpeed;
    private int badmintonSpeedCount;
    private int barometerStatus;

    @Nullable
    private List<Integer> bsBadmintonSpeed;
    private int bsBadmintonSpeedCount;
    private int bsTackLength;

    @Nullable
    private List<Integer> bsTennisSpeed;
    private int bsTennisSpeedCount;
    private long bsTotalDistance;

    @Nullable
    private List<Integer> bsTurnsDistance;
    private int count;
    private int cumulativeDecline;
    private int dataSource;
    private int elevation;
    private int ellipticalTotalNum;
    private int fatTime;
    private int fitSourceType;

    @Nullable
    private List<? extends FiveKmPlan> fiveKmPlans;
    private int foreHandNum;
    private int foreHandPrecent;
    private int foreHandSlice;
    private int foreHandTopspin;
    private int gpsVersionInfo;
    private int hrSectionType;

    @Nullable
    private List<Integer> hrZone;

    @Nullable
    private List<Integer> kmPace;
    private int lap;

    @Nullable
    private String lapDetail;
    private int limitHrmUpper;
    private int maxEllipticalFreq;
    private int maxHeartRate;
    private float maxInclination;
    private int maxRowingFreq;
    private int maxStride;
    private int maxSwingFreq;
    private int maxSwingSpeed;
    private int maxTribble;

    @Nullable
    private List<Integer> milePace;
    private int numberOfTurns;
    private int overHandNum;
    private int poolLength;
    private int recordGrade;
    private int recoveryTime;
    private int reducingFatHrmUpper;
    private int relativeHeight;
    private int rowingTotalNum;

    @Nullable
    private String skiDetail;
    private int skiDuration;
    private int stamina;
    private int staminaHrmUpper;
    private float staminaLevel;
    private int stanceBalanceEvaluate;
    private int stanceTimeEvaluate;
    private int stride;
    private int tennisServe;

    @Nullable
    private List<Integer> tennisSpeed;
    private int tennisSpeedCount;
    private int totalBatting;
    private int trackLength;
    private int trackNumber;
    private int trainingEffect;

    @Nullable
    private List<Integer> turnsDistance;

    @Nullable
    private List<Integer> turnsPace;
    private int underHandNum;
    private int vailActive;
    private int vailDefense;
    private int vailErupt;
    private int vailRivalry;
    private int vailStamina;
    private int verticalEvaluate;
    private int verticalRatioEvaluate;
    private float vo2max;
    private int warnUpHrmLower;
    private int warnUpHrmUpper;
    private int vo2maxLevel = -1;
    private float altitude = Float.MAX_VALUE;
    private int avgBalance = -1;
    private int segmentation = 2;

    public final int getActiveDuration() {
        return this.activeDuration;
    }

    public final int getActiveTime() {
        return this.activeTime;
    }

    public final float getAdh() {
        return this.adh;
    }

    public final int getAerobicHrmUpper() {
        return this.aerobicHrmUpper;
    }

    public final float getAltitude() {
        return this.altitude;
    }

    public final int getAutoRecognize() {
        return this.autoRecognize;
    }

    public final int getAvgBalance() {
        return this.avgBalance;
    }

    public final int getAvgEllipticalFreq() {
        return this.avgEllipticalFreq;
    }

    public final int getAvgPower() {
        return this.avgPower;
    }

    public final int getAvgRowingFreq() {
        return this.avgRowingFreq;
    }

    public final int getAvgRunningSpeed() {
        return this.avgRunningSpeed;
    }

    public final int getAvgSpeed() {
        return this.avgSpeed;
    }

    public final int getAvgStance() {
        return this.avgStance;
    }

    public final int getAvgSwingFreq() {
        return this.avgSwingFreq;
    }

    public final int getAvgVertical() {
        return this.avgVertical;
    }

    public final int getAvgVerticalRatio() {
        return this.avgVerticalRatio;
    }

    public final int getBackHandNum() {
        return this.backHandNum;
    }

    public final int getBackHandSlice() {
        return this.backHandSlice;
    }

    public final int getBackHandTopspin() {
        return this.backHandTopspin;
    }

    @Nullable
    public final List<Integer> getBadmintonSpeed() {
        return this.badmintonSpeed;
    }

    public final int getBadmintonSpeedCount() {
        return this.badmintonSpeedCount;
    }

    public final int getBarometerStatus() {
        return this.barometerStatus;
    }

    @Nullable
    public final List<Integer> getBsBadmintonSpeed() {
        return this.bsBadmintonSpeed;
    }

    public final int getBsBadmintonSpeedCount() {
        return this.bsBadmintonSpeedCount;
    }

    public final int getBsTackLength() {
        return this.bsTackLength;
    }

    @Nullable
    public final List<Integer> getBsTennisSpeed() {
        return this.bsTennisSpeed;
    }

    public final int getBsTennisSpeedCount() {
        return this.bsTennisSpeedCount;
    }

    public final long getBsTotalDistance() {
        return this.bsTotalDistance;
    }

    @Nullable
    public final List<Integer> getBsTurnsDistance() {
        return this.bsTurnsDistance;
    }

    public final int getCount() {
        return this.count;
    }

    public final int getCumulativeDecline() {
        return this.cumulativeDecline;
    }

    public final int getDataSource() {
        return this.dataSource;
    }

    public final int getElevation() {
        return this.elevation;
    }

    public final int getEllipticalTotalNum() {
        return this.ellipticalTotalNum;
    }

    public final int getFatTime() {
        return this.fatTime;
    }

    public final int getFitSourceType() {
        return this.fitSourceType;
    }

    @Nullable
    public final List<FiveKmPlan> getFiveKmPlans() {
        return this.fiveKmPlans;
    }

    public final int getForeHandNum() {
        return this.foreHandNum;
    }

    public final int getForeHandPrecent() {
        return this.foreHandPrecent;
    }

    public final int getForeHandSlice() {
        return this.foreHandSlice;
    }

    public final int getForeHandTopspin() {
        return this.foreHandTopspin;
    }

    public final int getGpsVersionInfo() {
        return this.gpsVersionInfo;
    }

    public final int getHrSectionType() {
        return this.hrSectionType;
    }

    @Nullable
    public final List<Integer> getHrZone() {
        return this.hrZone;
    }

    @Nullable
    public final List<Integer> getKmPace() {
        return this.kmPace;
    }

    public final int getLap() {
        return this.lap;
    }

    @Nullable
    public final String getLapDetail() {
        return this.lapDetail;
    }

    public final int getLimitHrmUpper() {
        return this.limitHrmUpper;
    }

    public final int getMaxEllipticalFreq() {
        return this.maxEllipticalFreq;
    }

    public final int getMaxHeartRate() {
        return this.maxHeartRate;
    }

    public final float getMaxInclination() {
        return this.maxInclination;
    }

    public final int getMaxRowingFreq() {
        return this.maxRowingFreq;
    }

    public final int getMaxStride() {
        return this.maxStride;
    }

    public final int getMaxSwingFreq() {
        return this.maxSwingFreq;
    }

    public final int getMaxSwingSpeed() {
        return this.maxSwingSpeed;
    }

    public final int getMaxTribble() {
        return this.maxTribble;
    }

    @Nullable
    public final List<Integer> getMilePace() {
        return this.milePace;
    }

    public final int getNumberOfTurns() {
        return this.numberOfTurns;
    }

    public final int getOverHandNum() {
        return this.overHandNum;
    }

    public final int getPoolLength() {
        return this.poolLength;
    }

    public final int getRecordGrade() {
        return this.recordGrade;
    }

    public final int getRecoveryTime() {
        return this.recoveryTime;
    }

    public final int getReducingFatHrmUpper() {
        return this.reducingFatHrmUpper;
    }

    public final int getRelativeHeight() {
        return this.relativeHeight;
    }

    public final int getRowingTotalNum() {
        return this.rowingTotalNum;
    }

    public final int getSegmentation() {
        return this.segmentation;
    }

    @Nullable
    public final String getSkiDetail() {
        return this.skiDetail;
    }

    public final int getSkiDuration() {
        return this.skiDuration;
    }

    public final int getStamina() {
        return this.stamina;
    }

    public final int getStaminaHrmUpper() {
        return this.staminaHrmUpper;
    }

    public final float getStaminaLevel() {
        return this.staminaLevel;
    }

    public final int getStanceBalanceEvaluate() {
        return this.stanceBalanceEvaluate;
    }

    public final int getStanceTimeEvaluate() {
        return this.stanceTimeEvaluate;
    }

    public final int getStride() {
        return this.stride;
    }

    public final int getTennisServe() {
        return this.tennisServe;
    }

    @Nullable
    public final List<Integer> getTennisSpeed() {
        return this.tennisSpeed;
    }

    public final int getTennisSpeedCount() {
        return this.tennisSpeedCount;
    }

    public final int getTotalBatting() {
        return this.totalBatting;
    }

    public final int getTrackLength() {
        return this.trackLength;
    }

    public final int getTrackNumber() {
        return this.trackNumber;
    }

    public final int getTrainingEffect() {
        return this.trainingEffect;
    }

    @Nullable
    public final List<Integer> getTurnsDistance() {
        return this.turnsDistance;
    }

    @Nullable
    public final List<Integer> getTurnsPace() {
        return this.turnsPace;
    }

    public final int getUnderHandNum() {
        return this.underHandNum;
    }

    public final int getVailActive() {
        return this.vailActive;
    }

    public final int getVailDefense() {
        return this.vailDefense;
    }

    public final int getVailErupt() {
        return this.vailErupt;
    }

    public final int getVailRivalry() {
        return this.vailRivalry;
    }

    public final int getVailStamina() {
        return this.vailStamina;
    }

    public final int getVerticalEvaluate() {
        return this.verticalEvaluate;
    }

    public final int getVerticalRatioEvaluate() {
        return this.verticalRatioEvaluate;
    }

    public final float getVo2max() {
        return this.vo2max;
    }

    public final int getVo2maxLevel() {
        return this.vo2maxLevel;
    }

    public final int getWarnUpHrmLower() {
        return this.warnUpHrmLower;
    }

    public final int getWarnUpHrmUpper() {
        return this.warnUpHrmUpper;
    }

    public final void setActiveDuration(int i3) {
        this.activeDuration = i3;
    }

    public final void setActiveTime(int i3) {
        this.activeTime = i3;
    }

    public final void setAdh(float f16) {
        this.adh = f16;
    }

    public final void setAerobicHrmUpper(int i3) {
        this.aerobicHrmUpper = i3;
    }

    public final void setAltitude(float f16) {
        this.altitude = f16;
    }

    public final void setAutoRecognize(int i3) {
        this.autoRecognize = i3;
    }

    public final void setAvgBalance(int i3) {
        this.avgBalance = i3;
    }

    public final void setAvgEllipticalFreq(int i3) {
        this.avgEllipticalFreq = i3;
    }

    public final void setAvgPower(int i3) {
        this.avgPower = i3;
    }

    public final void setAvgRowingFreq(int i3) {
        this.avgRowingFreq = i3;
    }

    public final void setAvgRunningSpeed(int i3) {
        this.avgRunningSpeed = i3;
    }

    public final void setAvgSpeed(int i3) {
        this.avgSpeed = i3;
    }

    public final void setAvgStance(int i3) {
        this.avgStance = i3;
    }

    public final void setAvgSwingFreq(int i3) {
        this.avgSwingFreq = i3;
    }

    public final void setAvgVertical(int i3) {
        this.avgVertical = i3;
    }

    public final void setAvgVerticalRatio(int i3) {
        this.avgVerticalRatio = i3;
    }

    public final void setBackHandNum(int i3) {
        this.backHandNum = i3;
    }

    public final void setBackHandSlice(int i3) {
        this.backHandSlice = i3;
    }

    public final void setBackHandTopspin(int i3) {
        this.backHandTopspin = i3;
    }

    public final void setBadmintonSpeed(@Nullable List<Integer> list) {
        this.badmintonSpeed = list;
    }

    public final void setBadmintonSpeedCount(int i3) {
        this.badmintonSpeedCount = i3;
    }

    public final void setBarometerStatus(int i3) {
        this.barometerStatus = i3;
    }

    public final void setBsBadmintonSpeed(@Nullable List<Integer> list) {
        this.bsBadmintonSpeed = list;
    }

    public final void setBsBadmintonSpeedCount(int i3) {
        this.bsBadmintonSpeedCount = i3;
    }

    public final void setBsTackLength(int i3) {
        this.bsTackLength = i3;
    }

    public final void setBsTennisSpeed(@Nullable List<Integer> list) {
        this.bsTennisSpeed = list;
    }

    public final void setBsTennisSpeedCount(int i3) {
        this.bsTennisSpeedCount = i3;
    }

    public final void setBsTotalDistance(long j3) {
        this.bsTotalDistance = j3;
    }

    public final void setBsTurnsDistance(@Nullable List<Integer> list) {
        this.bsTurnsDistance = list;
    }

    public final void setCount(int i3) {
        this.count = i3;
    }

    public final void setCumulativeDecline(int i3) {
        this.cumulativeDecline = i3;
    }

    public final void setDataSource(int i3) {
        this.dataSource = i3;
    }

    public final void setElevation(int i3) {
        this.elevation = i3;
    }

    public final void setEllipticalTotalNum(int i3) {
        this.ellipticalTotalNum = i3;
    }

    public final void setFatTime(int i3) {
        this.fatTime = i3;
    }

    public final void setFitSourceType(int i3) {
        this.fitSourceType = i3;
    }

    public final void setFiveKmPlans(@Nullable List<? extends FiveKmPlan> list) {
        this.fiveKmPlans = list;
    }

    public final void setForeHandNum(int i3) {
        this.foreHandNum = i3;
    }

    public final void setForeHandPrecent(int i3) {
        this.foreHandPrecent = i3;
    }

    public final void setForeHandSlice(int i3) {
        this.foreHandSlice = i3;
    }

    public final void setForeHandTopspin(int i3) {
        this.foreHandTopspin = i3;
    }

    public final void setGpsVersionInfo(int i3) {
        this.gpsVersionInfo = i3;
    }

    public final void setHrSectionType(int i3) {
        this.hrSectionType = i3;
    }

    public final void setHrZone(@Nullable List<Integer> list) {
        this.hrZone = list;
    }

    public final void setKmPace(@Nullable List<Integer> list) {
        this.kmPace = list;
    }

    public final void setLap(int i3) {
        this.lap = i3;
    }

    public final void setLapDetail(@Nullable String str) {
        this.lapDetail = str;
    }

    public final void setLimitHrmUpper(int i3) {
        this.limitHrmUpper = i3;
    }

    public final void setMaxEllipticalFreq(int i3) {
        this.maxEllipticalFreq = i3;
    }

    public final void setMaxHeartRate(int i3) {
        this.maxHeartRate = i3;
    }

    public final void setMaxInclination(float f16) {
        this.maxInclination = f16;
    }

    public final void setMaxRowingFreq(int i3) {
        this.maxRowingFreq = i3;
    }

    public final void setMaxStride(int i3) {
        this.maxStride = i3;
    }

    public final void setMaxSwingFreq(int i3) {
        this.maxSwingFreq = i3;
    }

    public final void setMaxSwingSpeed(int i3) {
        this.maxSwingSpeed = i3;
    }

    public final void setMaxTribble(int i3) {
        this.maxTribble = i3;
    }

    public final void setMilePace(@Nullable List<Integer> list) {
        this.milePace = list;
    }

    public final void setNumberOfTurns(int i3) {
        this.numberOfTurns = i3;
    }

    public final void setOverHandNum(int i3) {
        this.overHandNum = i3;
    }

    public final void setPoolLength(int i3) {
        this.poolLength = i3;
    }

    public final void setRecordGrade(int i3) {
        this.recordGrade = i3;
    }

    public final void setRecoveryTime(int i3) {
        this.recoveryTime = i3;
    }

    public final void setReducingFatHrmUpper(int i3) {
        this.reducingFatHrmUpper = i3;
    }

    public final void setRelativeHeight(int i3) {
        this.relativeHeight = i3;
    }

    public final void setRowingTotalNum(int i3) {
        this.rowingTotalNum = i3;
    }

    public final void setSegmentation(int i3) {
        this.segmentation = i3;
    }

    public final void setSkiDetail(@Nullable String str) {
        this.skiDetail = str;
    }

    public final void setSkiDuration(int i3) {
        this.skiDuration = i3;
    }

    public final void setStamina(int i3) {
        this.stamina = i3;
    }

    public final void setStaminaHrmUpper(int i3) {
        this.staminaHrmUpper = i3;
    }

    public final void setStaminaLevel(float f16) {
        this.staminaLevel = f16;
    }

    public final void setStanceBalanceEvaluate(int i3) {
        this.stanceBalanceEvaluate = i3;
    }

    public final void setStanceTimeEvaluate(int i3) {
        this.stanceTimeEvaluate = i3;
    }

    public final void setStride(int i3) {
        this.stride = i3;
    }

    public final void setTennisServe(int i3) {
        this.tennisServe = i3;
    }

    public final void setTennisSpeed(@Nullable List<Integer> list) {
        this.tennisSpeed = list;
    }

    public final void setTennisSpeedCount(int i3) {
        this.tennisSpeedCount = i3;
    }

    public final void setTotalBatting(int i3) {
        this.totalBatting = i3;
    }

    public final void setTrackLength(int i3) {
        this.trackLength = i3;
    }

    public final void setTrackNumber(int i3) {
        this.trackNumber = i3;
    }

    public final void setTrainingEffect(int i3) {
        this.trainingEffect = i3;
    }

    public final void setTurnsDistance(@Nullable List<Integer> list) {
        this.turnsDistance = list;
    }

    public final void setTurnsPace(@Nullable List<Integer> list) {
        this.turnsPace = list;
    }

    public final void setUnderHandNum(int i3) {
        this.underHandNum = i3;
    }

    public final void setVailActive(int i3) {
        this.vailActive = i3;
    }

    public final void setVailDefense(int i3) {
        this.vailDefense = i3;
    }

    public final void setVailErupt(int i3) {
        this.vailErupt = i3;
    }

    public final void setVailRivalry(int i3) {
        this.vailRivalry = i3;
    }

    public final void setVailStamina(int i3) {
        this.vailStamina = i3;
    }

    public final void setVerticalEvaluate(int i3) {
        this.verticalEvaluate = i3;
    }

    public final void setVerticalRatioEvaluate(int i3) {
        this.verticalRatioEvaluate = i3;
    }

    public final void setVo2max(float f16) {
        this.vo2max = f16;
    }

    public final void setVo2maxLevel(int i3) {
        this.vo2maxLevel = i3;
    }

    public final void setWarnUpHrmLower(int i3) {
        this.warnUpHrmLower = i3;
    }

    public final void setWarnUpHrmUpper(int i3) {
        this.warnUpHrmUpper = i3;
    }
}
