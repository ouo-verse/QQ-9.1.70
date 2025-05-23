package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GlideException extends Exception {

    /* renamed from: d, reason: collision with root package name */
    private static final StackTraceElement[] f31638d = new StackTraceElement[0];
    private static final long serialVersionUID = 1;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private DataSource dataSource;
    private String detailMessage;

    @Nullable
    private Exception exception;
    private com.bumptech.glide.load.c key;

    public GlideException(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    private void a(Throwable th5, List<Throwable> list) {
        if (th5 instanceof GlideException) {
            Iterator<Throwable> it = ((GlideException) th5).getCauses().iterator();
            while (it.hasNext()) {
                a(it.next(), list);
            }
            return;
        }
        list.add(th5);
    }

    private static void b(List<Throwable> list, Appendable appendable) {
        try {
            c(list, appendable);
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    private static void c(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i3 = 0;
        while (i3 < size) {
            int i16 = i3 + 1;
            appendable.append("Cause (").append(String.valueOf(i16)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th5 = list.get(i3);
            if (th5 instanceof GlideException) {
                ((GlideException) th5).e(appendable);
            } else {
                d(th5, appendable);
            }
            i3 = i16;
        }
    }

    private static void d(Throwable th5, Appendable appendable) {
        try {
            appendable.append(th5.getClass().toString()).append(MsgSummary.STR_COLON).append(th5.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th5);
        }
    }

    private void e(Appendable appendable) {
        d(this, appendable);
        b(getCauses(), new a(appendable));
    }

    public List<Throwable> getCauses() {
        return this.causes;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str;
        String str2;
        StringBuilder sb5 = new StringBuilder(71);
        sb5.append(this.detailMessage);
        String str3 = "";
        if (this.dataClass == null) {
            str = "";
        } else {
            str = ", " + this.dataClass;
        }
        sb5.append(str);
        if (this.dataSource == null) {
            str2 = "";
        } else {
            str2 = ", " + this.dataSource;
        }
        sb5.append(str2);
        if (this.key != null) {
            str3 = ", " + this.key;
        }
        sb5.append(str3);
        List<Throwable> rootCauses = getRootCauses();
        if (rootCauses.isEmpty()) {
            return sb5.toString();
        }
        if (rootCauses.size() == 1) {
            sb5.append("\nThere was 1 root cause:");
        } else {
            sb5.append("\nThere were ");
            sb5.append(rootCauses.size());
            sb5.append(" root causes:");
        }
        for (Throwable th5 : rootCauses) {
            sb5.append('\n');
            sb5.append(th5.getClass().getName());
            sb5.append('(');
            sb5.append(th5.getMessage());
            sb5.append(')');
        }
        sb5.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb5.toString();
    }

    @Nullable
    public Exception getOrigin() {
        return this.exception;
    }

    public List<Throwable> getRootCauses() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    public void logRootCauses(String str) {
        List<Throwable> rootCauses = getRootCauses();
        int size = rootCauses.size();
        int i3 = 0;
        while (i3 < size) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Root cause (");
            int i16 = i3 + 1;
            sb5.append(i16);
            sb5.append(" of ");
            sb5.append(size);
            sb5.append(")");
            Log.i(str, sb5.toString(), rootCauses.get(i3));
            i3 = i16;
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLoggingDetails(com.bumptech.glide.load.c cVar, DataSource dataSource) {
        setLoggingDetails(cVar, dataSource, null);
    }

    public void setOrigin(@Nullable Exception exc) {
        this.exception = exc;
    }

    public GlideException(String str, Throwable th5) {
        this(str, (List<Throwable>) Collections.singletonList(th5));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        e(printStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLoggingDetails(com.bumptech.glide.load.c cVar, DataSource dataSource, Class<?> cls) {
        this.key = cVar;
        this.dataSource = dataSource;
        this.dataClass = cls;
    }

    public GlideException(String str, List<Throwable> list) {
        this.detailMessage = str;
        setStackTrace(f31638d);
        this.causes = list;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        e(printWriter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class a implements Appendable {

        /* renamed from: d, reason: collision with root package name */
        private final Appendable f31639d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f31640e = true;

        a(Appendable appendable) {
            this.f31639d = appendable;
        }

        @NonNull
        private CharSequence a(@Nullable CharSequence charSequence) {
            if (charSequence == null) {
                return "";
            }
            return charSequence;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c16) throws IOException {
            if (this.f31640e) {
                this.f31640e = false;
                this.f31639d.append("  ");
            }
            this.f31640e = c16 == '\n';
            this.f31639d.append(c16);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence charSequence) throws IOException {
            CharSequence a16 = a(charSequence);
            return append(a16, 0, a16.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence charSequence, int i3, int i16) throws IOException {
            CharSequence a16 = a(charSequence);
            boolean z16 = false;
            if (this.f31640e) {
                this.f31640e = false;
                this.f31639d.append("  ");
            }
            if (a16.length() > 0 && a16.charAt(i16 - 1) == '\n') {
                z16 = true;
            }
            this.f31640e = z16;
            this.f31639d.append(a16, i3, i16);
            return this;
        }
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
