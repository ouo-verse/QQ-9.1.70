package org.apache.commons.lang.exception;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
public class NestableDelegate implements Serializable {
    private static final transient String MUST_BE_THROWABLE = "The Nestable implementation passed to the NestableDelegate(Nestable) constructor must extend java.lang.Throwable";
    static /* synthetic */ Class class$org$apache$commons$lang$exception$Nestable = null;
    public static boolean matchSubclasses = true;
    private static final long serialVersionUID = 1;
    public static boolean topDown = true;
    public static boolean trimStackFrames = true;
    private Throwable nestable;

    /* JADX WARN: Multi-variable type inference failed */
    public NestableDelegate(Nestable nestable) {
        this.nestable = null;
        if (nestable instanceof Throwable) {
            this.nestable = (Throwable) nestable;
            return;
        }
        throw new IllegalArgumentException(MUST_BE_THROWABLE);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e16) {
            throw new NoClassDefFoundError(e16.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getMessage(int i3) {
        Throwable throwable = getThrowable(i3);
        Class cls = class$org$apache$commons$lang$exception$Nestable;
        Class cls2 = cls;
        if (cls == null) {
            Class class$ = class$("org.apache.commons.lang.exception.Nestable");
            class$org$apache$commons$lang$exception$Nestable = class$;
            cls2 = class$;
        }
        if (cls2.isInstance(throwable)) {
            return ((Nestable) throwable).getMessage(0);
        }
        return throwable.getMessage();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String[] getMessages() {
        String message;
        Throwable[] throwables = getThrowables();
        String[] strArr = new String[throwables.length];
        for (int i3 = 0; i3 < throwables.length; i3++) {
            Class cls = class$org$apache$commons$lang$exception$Nestable;
            Class cls2 = cls;
            if (cls == null) {
                Class class$ = class$("org.apache.commons.lang.exception.Nestable");
                class$org$apache$commons$lang$exception$Nestable = class$;
                cls2 = class$;
            }
            if (cls2.isInstance(throwables[i3])) {
                message = ((Nestable) throwables[i3]).getMessage(0);
            } else {
                message = throwables[i3].getMessage();
            }
            strArr[i3] = message;
        }
        return strArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String[] getStackFrames(Throwable th5) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter((Writer) stringWriter, true);
        if (th5 instanceof Nestable) {
            ((Nestable) th5).printPartialStackTrace(printWriter);
        } else {
            th5.printStackTrace(printWriter);
        }
        return ExceptionUtils.getStackFrames(stringWriter.getBuffer().toString());
    }

    public Throwable getThrowable(int i3) {
        if (i3 == 0) {
            return this.nestable;
        }
        return getThrowables()[i3];
    }

    public int getThrowableCount() {
        return ExceptionUtils.getThrowableCount(this.nestable);
    }

    public Throwable[] getThrowables() {
        return ExceptionUtils.getThrowables(this.nestable);
    }

    public int indexOfThrowable(Class cls, int i3) {
        if (cls == null) {
            return -1;
        }
        if (i3 >= 0) {
            Throwable[] throwables = ExceptionUtils.getThrowables(this.nestable);
            if (i3 < throwables.length) {
                if (matchSubclasses) {
                    while (i3 < throwables.length) {
                        if (cls.isAssignableFrom(throwables[i3].getClass())) {
                            return i3;
                        }
                        i3++;
                    }
                } else {
                    while (i3 < throwables.length) {
                        if (cls.equals(throwables[i3].getClass())) {
                            return i3;
                        }
                        i3++;
                    }
                }
                return -1;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("The start index was out of bounds: ");
            stringBuffer.append(i3);
            stringBuffer.append(" >= ");
            stringBuffer.append(throwables.length);
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("The start index was out of bounds: ");
        stringBuffer2.append(i3);
        throw new IndexOutOfBoundsException(stringBuffer2.toString());
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    protected void trimStackFrames(List list) {
        for (int size = list.size() - 1; size > 0; size--) {
            String[] strArr = (String[]) list.get(size);
            String[] strArr2 = (String[]) list.get(size - 1);
            ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
            ExceptionUtils.removeCommonFrames(arrayList, new ArrayList(Arrays.asList(strArr2)));
            int length = strArr.length - arrayList.size();
            if (length > 0) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("\t... ");
                stringBuffer.append(length);
                stringBuffer.append(" more");
                arrayList.add(stringBuffer.toString());
                list.set(size, arrayList.toArray(new String[arrayList.size()]));
            }
        }
    }

    public void printStackTrace(PrintStream printStream) {
        synchronized (printStream) {
            PrintWriter printWriter = new PrintWriter((OutputStream) printStream, false);
            printStackTrace(printWriter);
            printWriter.flush();
        }
    }

    public String getMessage(String str) {
        Throwable cause = ExceptionUtils.getCause(this.nestable);
        String message = cause == null ? null : cause.getMessage();
        if (cause == null || message == null) {
            return str;
        }
        if (str == null) {
            return message;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(MsgSummary.STR_COLON);
        stringBuffer.append(message);
        return stringBuffer.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void printStackTrace(PrintWriter printWriter) {
        Throwable th5 = this.nestable;
        if (ExceptionUtils.isThrowableNested()) {
            if (th5 instanceof Nestable) {
                ((Nestable) th5).printPartialStackTrace(printWriter);
                return;
            } else {
                th5.printStackTrace(printWriter);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Throwable th6 = th5; th6 != null; th6 = ExceptionUtils.getCause(th6)) {
            arrayList.add(getStackFrames(th6));
        }
        String str = "Caused by: ";
        if (!topDown) {
            str = "Rethrown as: ";
            Collections.reverse(arrayList);
        }
        if (trimStackFrames) {
            trimStackFrames(arrayList);
        }
        synchronized (printWriter) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                for (String str2 : (String[]) it.next()) {
                    printWriter.println(str2);
                }
                if (it.hasNext()) {
                    printWriter.print(str);
                }
            }
        }
    }
}
