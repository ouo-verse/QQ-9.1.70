package org.junit.runner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.internal.Classes;
import org.junit.runner.FilterFactory;
import org.junit.runners.model.InitializationError;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes29.dex */
public class JUnitCommandLineParseResult {
    private final List<String> filterSpecs = new ArrayList();
    private final List<Class<?>> classes = new ArrayList();
    private final List<Throwable> parserErrors = new ArrayList();

    /* loaded from: classes29.dex */
    public static class CommandLineParserError extends Exception {
        private static final long serialVersionUID = 1;

        public CommandLineParserError(String str) {
            super(str);
        }
    }

    JUnitCommandLineParseResult() {
    }

    private Request applyFilterSpecs(Request request) {
        try {
            Iterator<String> it = this.filterSpecs.iterator();
            while (it.hasNext()) {
                request = request.filterWith(FilterFactories.createFilterFromFilterSpec(request, it.next()));
            }
            return request;
        } catch (FilterFactory.FilterNotCreatedException e16) {
            return errorReport(e16);
        }
    }

    private String[] copyArray(String[] strArr, int i3, int i16) {
        ArrayList arrayList = new ArrayList();
        while (i3 != i16) {
            arrayList.add(strArr[i3]);
            i3++;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private Request errorReport(Throwable th5) {
        return Request.errorReport(JUnitCommandLineParseResult.class, th5);
    }

    public static JUnitCommandLineParseResult parse(String[] strArr) {
        JUnitCommandLineParseResult jUnitCommandLineParseResult = new JUnitCommandLineParseResult();
        jUnitCommandLineParseResult.parseArgs(strArr);
        return jUnitCommandLineParseResult;
    }

    private void parseArgs(String[] strArr) {
        parseParameters(parseOptions(strArr));
    }

    public Request createRequest(Computer computer) {
        if (this.parserErrors.isEmpty()) {
            List<Class<?>> list = this.classes;
            return applyFilterSpecs(Request.classes(computer, (Class[]) list.toArray(new Class[list.size()])));
        }
        return errorReport(new InitializationError(this.parserErrors));
    }

    public List<Class<?>> getClasses() {
        return Collections.unmodifiableList(this.classes);
    }

    public List<String> getFilterSpecs() {
        return Collections.unmodifiableList(this.filterSpecs);
    }

    String[] parseOptions(String... strArr) {
        String substring;
        int i3 = 0;
        while (true) {
            if (i3 == strArr.length) {
                break;
            }
            String str = strArr[i3];
            if (str.equals("--")) {
                return copyArray(strArr, i3 + 1, strArr.length);
            }
            if (str.startsWith("--")) {
                if (!str.startsWith("--filter=") && !str.equals("--filter")) {
                    this.parserErrors.add(new CommandLineParserError("JUnit knows nothing about the " + str + " option"));
                } else {
                    if (str.equals("--filter")) {
                        i3++;
                        if (i3 < strArr.length) {
                            substring = strArr[i3];
                        } else {
                            this.parserErrors.add(new CommandLineParserError(str + " value not specified"));
                            break;
                        }
                    } else {
                        substring = str.substring(str.indexOf(61) + 1);
                    }
                    this.filterSpecs.add(substring);
                }
                i3++;
            } else {
                return copyArray(strArr, i3, strArr.length);
            }
        }
        return new String[0];
    }

    void parseParameters(String[] strArr) {
        for (String str : strArr) {
            try {
                this.classes.add(Classes.getClass(str));
            } catch (ClassNotFoundException e16) {
                this.parserErrors.add(new IllegalArgumentException("Could not find class [" + str + "]", e16));
            }
        }
    }
}
