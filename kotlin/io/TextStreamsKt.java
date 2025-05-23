package kotlin.io;

import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r\u001a\u0010\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010*\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0013\u001a\u0010\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015*\u00020\u0002\u001a\n\u0010\u0016\u001a\u00020\u000e*\u00020\u0002\u001a\u0017\u0010\u0016\u001a\u00020\u000e*\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u001a*\u00020\u000eH\u0087\b\u001a5\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c*\u00020\u00022\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0010\u0012\u0004\u0012\u0002H\u001c0\rH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001f"}, d2 = {InnerAudioPlugin.AUDIO_PROPERTY_BUFFERED, "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", "", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "copyTo", "", "out", "forEachLine", "", "action", "Lkotlin/Function1;", "", "lineSequence", "Lkotlin/sequences/Sequence;", "readBytes", "", "Ljava/net/URL;", "readLines", "", "readText", HttpMsg.CHARSET, "Ljava/nio/charset/Charset;", "reader", "Ljava/io/StringReader;", "useLines", "T", "block", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "TextStreamsKt")
/* loaded from: classes28.dex */
public final class TextStreamsKt {
    @InlineOnly
    private static final BufferedReader buffered(Reader reader, int i3) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i3);
    }

    static /* synthetic */ BufferedReader buffered$default(Reader reader, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 8192;
        }
        Intrinsics.checkNotNullParameter(reader, "<this>");
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i3);
    }

    public static final long copyTo(@NotNull Reader reader, @NotNull Writer out, int i3) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        char[] cArr = new char[i3];
        int read = reader.read(cArr);
        long j3 = 0;
        while (read >= 0) {
            out.write(cArr, 0, read);
            j3 += read;
            read = reader.read(cArr);
        }
        return j3;
    }

    public static /* synthetic */ long copyTo$default(Reader reader, Writer writer, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 8192;
        }
        return copyTo(reader, writer, i3);
    }

    public static final void forEachLine(@NotNull Reader reader, @NotNull Function1<? super String, Unit> action) {
        BufferedReader bufferedReader;
        Intrinsics.checkNotNullParameter(reader, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        if (reader instanceof BufferedReader) {
            bufferedReader = (BufferedReader) reader;
        } else {
            bufferedReader = new BufferedReader(reader, 8192);
        }
        try {
            Iterator<String> it = lineSequence(bufferedReader).iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedReader, null);
        } finally {
        }
    }

    @NotNull
    public static final Sequence<String> lineSequence(@NotNull BufferedReader bufferedReader) {
        Sequence<String> constrainOnce;
        Intrinsics.checkNotNullParameter(bufferedReader, "<this>");
        constrainOnce = SequencesKt__SequencesKt.constrainOnce(new LinesSequence(bufferedReader));
        return constrainOnce;
    }

    @NotNull
    public static final byte[] readBytes(@NotNull URL url) {
        Intrinsics.checkNotNullParameter(url, "<this>");
        InputStream it = url.openStream();
        try {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            byte[] readBytes = ByteStreamsKt.readBytes(it);
            CloseableKt.closeFinally(it, null);
            return readBytes;
        } finally {
        }
    }

    @NotNull
    public static final List<String> readLines(@NotNull Reader reader) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        final ArrayList arrayList = new ArrayList();
        forEachLine(reader, new Function1<String, Unit>() { // from class: kotlin.io.TextStreamsKt$readLines$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                arrayList.add(it);
            }
        });
        return arrayList;
    }

    @NotNull
    public static final String readText(@NotNull Reader reader) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        copyTo$default(reader, stringWriter, 0, 2, null);
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "buffer.toString()");
        return stringWriter2;
    }

    static /* synthetic */ String readText$default(URL url, Charset charset, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(url, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(readBytes(url), charset);
    }

    @InlineOnly
    private static final StringReader reader(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new StringReader(str);
    }

    public static final <T> T useLines(@NotNull Reader reader, @NotNull Function1<? super Sequence<String>, ? extends T> block) {
        BufferedReader bufferedReader;
        Intrinsics.checkNotNullParameter(reader, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (reader instanceof BufferedReader) {
            bufferedReader = (BufferedReader) reader;
        } else {
            bufferedReader = new BufferedReader(reader, 8192);
        }
        try {
            T invoke = block.invoke(lineSequence(bufferedReader));
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(bufferedReader, null);
            InlineMarker.finallyEnd(1);
            return invoke;
        } finally {
        }
    }

    @InlineOnly
    private static final BufferedWriter buffered(Writer writer, int i3) {
        Intrinsics.checkNotNullParameter(writer, "<this>");
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i3);
    }

    static /* synthetic */ BufferedWriter buffered$default(Writer writer, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 8192;
        }
        Intrinsics.checkNotNullParameter(writer, "<this>");
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i3);
    }

    @InlineOnly
    private static final String readText(URL url, Charset charset) {
        Intrinsics.checkNotNullParameter(url, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(readBytes(url), charset);
    }
}
