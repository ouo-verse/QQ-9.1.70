package com.samskivert.mustache;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.MustacheException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Template {
    protected static final String DOT_NAME = ".";
    protected static final String FIRST_NAME = "-first";
    protected static final String INDEX_NAME = "-index";
    protected static final String LAST_NAME = "-last";
    protected static final String THIS_NAME = "this";
    protected final Mustache.Compiler _compiler;
    protected final Map<Key, Mustache.VariableFetcher> _fcache;
    protected final Segment[] _segs;
    public static final Object NO_FETCHER_FOUND = new String("<no fetcher found>");
    protected static Mustache.VariableFetcher NOT_FOUND_FETCHER = new Mustache.VariableFetcher() { // from class: com.samskivert.mustache.Template.2
        @Override // com.samskivert.mustache.Mustache.VariableFetcher
        public Object get(Object obj, String str) throws Exception {
            return Template.NO_FETCHER_FOUND;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Context {
        public final Object data;
        public final int index;
        public final boolean onFirst;
        public final boolean onLast;
        public final Context parent;

        public Context(Object obj, Context context, int i3, boolean z16, boolean z17) {
            this.data = obj;
            this.parent = context;
            this.index = i3;
            this.onFirst = z16;
            this.onLast = z17;
        }

        public Context nest(Object obj) {
            return new Context(obj, this, this.index, this.onFirst, this.onLast);
        }

        public Context nest(Object obj, int i3, boolean z16, boolean z17) {
            return new Context(obj, this, i3, z16, z17);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Key {
        public final Class<?> cclass;
        public final String name;

        public Key(Class<?> cls, String str) {
            this.cclass = cls;
            this.name = str;
        }

        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if (key.cclass == this.cclass && key.name.equals(this.name)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.cclass.hashCode() * 31) + this.name.hashCode();
        }

        public String toString() {
            return this.cclass.getName() + ":" + this.name;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static abstract class Segment {
        /* JADX INFO: Access modifiers changed from: protected */
        public static void write(Writer writer, String str) {
            try {
                writer.write(str);
            } catch (IOException e16) {
                throw new MustacheException(e16);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract void decompile(Mustache.Delims delims, StringBuilder sb5);

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract void execute(Template template, Context context, Writer writer);

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract void visit(Mustache.Visitor visitor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Template(Segment[] segmentArr, Mustache.Compiler compiler) {
        this._segs = segmentArr;
        this._compiler = compiler;
        this._fcache = compiler.collector.createFetcherCache();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isThisName(String str) {
        if (!".".equals(str) && !"this".equals(str)) {
            return false;
        }
        return true;
    }

    protected Object checkForMissing(String str, int i3, boolean z16, Object obj) {
        if (obj == NO_FETCHER_FOUND) {
            if (z16) {
                return null;
            }
            throw new MustacheException.Context("No method or field with name '" + str + "' on line " + i3, str, i3);
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Fragment createFragment(final Segment[] segmentArr, final Context context) {
        return new Fragment() { // from class: com.samskivert.mustache.Template.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.samskivert.mustache.Template.Fragment
            public Object context() {
                return context.data;
            }

            @Override // com.samskivert.mustache.Template.Fragment
            public StringBuilder decompile(StringBuilder sb5) {
                for (Segment segment : segmentArr) {
                    segment.decompile(Template.this._compiler.delims, sb5);
                }
                return sb5;
            }

            @Override // com.samskivert.mustache.Template.Fragment
            public void execute(Writer writer) {
                execute(context, writer);
            }

            @Override // com.samskivert.mustache.Template.Fragment
            public void executeTemplate(Template template, Writer writer) {
                template.executeSegs(context, writer);
            }

            @Override // com.samskivert.mustache.Template.Fragment
            public Object context(int i3) {
                return context(context, i3);
            }

            @Override // com.samskivert.mustache.Template.Fragment
            public void execute(Object obj, Writer writer) {
                execute(context.nest(obj), writer);
            }

            private Object context(Context context2, int i3) {
                return i3 == 0 ? context2.data : context(context2.parent, i3 - 1);
            }

            private void execute(Context context2, Writer writer) {
                for (Segment segment : segmentArr) {
                    segment.execute(Template.this, context2, writer);
                }
            }
        };
    }

    public String execute(Object obj) throws MustacheException {
        StringWriter stringWriter = new StringWriter();
        execute(obj, stringWriter);
        return stringWriter.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void executeSegs(Context context, Writer writer) throws MustacheException {
        for (Segment segment : this._segs) {
            segment.execute(this, context, writer);
        }
    }

    protected Object getCompoundValue(Context context, String str, int i3, boolean z16) {
        String[] split = str.split("\\.");
        Object value = getValue(context, split[0], i3, z16);
        for (int i16 = 1; i16 < split.length; i16++) {
            if (value == NO_FETCHER_FOUND) {
                if (z16) {
                    return null;
                }
                throw new MustacheException.Context("Missing context for compound variable '" + str + "' on line " + i3 + ". '" + split[i16 - 1] + "' was not found.", str, i3);
            }
            if (value == null) {
                return null;
            }
            value = getValueIn(value, split[i16], i3);
        }
        return checkForMissing(str, i3, z16, value);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object getSectionValue(Context context, String str, int i3) {
        Object value = getValue(context, str, i3, !this._compiler.strictSections);
        if (value == null) {
            return Collections.emptyList();
        }
        return value;
    }

    protected Object getValue(Context context, String str, int i3, boolean z16) {
        if (str.equals(FIRST_NAME)) {
            return Boolean.valueOf(context.onFirst);
        }
        if (str.equals(LAST_NAME)) {
            return Boolean.valueOf(context.onLast);
        }
        if (str.equals(INDEX_NAME)) {
            return Integer.valueOf(context.index);
        }
        if (this._compiler.standardsMode) {
            return checkForMissing(str, i3, z16, getValueIn(context.data, str, i3));
        }
        for (Context context2 = context; context2 != null; context2 = context2.parent) {
            Object valueIn = getValueIn(context2.data, str, i3);
            if (valueIn != NO_FETCHER_FOUND) {
                return valueIn;
            }
        }
        if (!str.equals(".") && str.indexOf(".") != -1) {
            return getCompoundValue(context, str, i3, z16);
        }
        return checkForMissing(str, i3, z16, NO_FETCHER_FOUND);
    }

    protected Object getValueIn(Object obj, String str, int i3) {
        Mustache.VariableFetcher createFetcher;
        if (isThisName(str)) {
            return obj;
        }
        if (obj != null) {
            Key key = new Key(obj.getClass(), str);
            Mustache.VariableFetcher variableFetcher = this._fcache.get(key);
            if (variableFetcher != null) {
                try {
                    return variableFetcher.get(obj, str);
                } catch (Exception unused) {
                    createFetcher = this._compiler.collector.createFetcher(obj, key.name);
                }
            } else {
                createFetcher = this._compiler.collector.createFetcher(obj, key.name);
            }
            if (createFetcher == null) {
                createFetcher = NOT_FOUND_FETCHER;
            }
            try {
                Object obj2 = createFetcher.get(obj, str);
                this._fcache.put(key, createFetcher);
                return obj2;
            } catch (Exception e16) {
                throw new MustacheException.Context("Failure fetching variable '" + str + "' on line " + i3, str, i3, e16);
            }
        }
        throw new NullPointerException("Null context for variable '" + str + "' on line " + i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object getValueOrDefault(Context context, String str, int i3) {
        Object value = getValue(context, str, i3, this._compiler.missingIsNull);
        if (value == null) {
            return this._compiler.computeNullValue(str);
        }
        return value;
    }

    public void visit(Mustache.Visitor visitor) {
        for (Segment segment : this._segs) {
            segment.visit(visitor);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public abstract class Fragment {
        public Fragment() {
        }

        public abstract Object context();

        public abstract Object context(int i3);

        public String decompile() {
            return decompile(new StringBuilder()).toString();
        }

        public abstract StringBuilder decompile(StringBuilder sb5);

        public String execute() {
            StringWriter stringWriter = new StringWriter();
            execute((Writer) stringWriter);
            return stringWriter.toString();
        }

        public abstract void execute(Writer writer);

        public abstract void execute(Object obj, Writer writer);

        public abstract void executeTemplate(Template template, Writer writer);

        public String execute(Object obj) {
            StringWriter stringWriter = new StringWriter();
            execute(obj, stringWriter);
            return stringWriter.toString();
        }
    }

    public void execute(Object obj, Writer writer) throws MustacheException {
        executeSegs(new Context(obj, null, 0, false, false), writer);
    }

    public void execute(Object obj, Object obj2, Writer writer) throws MustacheException {
        executeSegs(new Context(obj, new Context(obj2, null, 0, false, false), 0, false, false), writer);
    }
}
