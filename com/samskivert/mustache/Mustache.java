package com.samskivert.mustache;

import com.huawei.hms.framework.common.ContainerUtils;
import com.samskivert.mustache.MustacheException;
import com.samskivert.mustache.Template;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Mustache {
    protected static final int MATCHING_END = 2;
    protected static final int MATCHING_START = 1;
    protected static final char NO_CHAR = 0;
    protected static final int TAG = 3;
    protected static final int TEXT = 0;
    protected static final TemplateLoader FAILING_LOADER = new TemplateLoader() { // from class: com.samskivert.mustache.Mustache.1
        @Override // com.samskivert.mustache.Mustache.TemplateLoader
        public Reader getTemplate(String str) {
            throw new UnsupportedOperationException("Template loading not configured");
        }
    };
    protected static final Formatter DEFAULT_FORMATTER = new Formatter() { // from class: com.samskivert.mustache.Mustache.2
        @Override // com.samskivert.mustache.Mustache.Formatter
        public String format(Object obj) {
            return String.valueOf(obj);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Accumulator {
        protected final Compiler _comp;
        protected final List<Template.Segment> _segs = new ArrayList();
        protected final boolean _topLevel;

        public Accumulator(Compiler compiler, boolean z16) {
            this._comp = compiler;
            this._topLevel = z16;
        }

        protected static void requireNoNewlines(String str, int i3) {
            if (str.indexOf(10) == -1 && str.indexOf(13) == -1) {
                return;
            }
            throw new MustacheParseException("Invalid tag name: contains newline '" + str + "'", i3);
        }

        protected static void requireSameName(String str, String str2, int i3) {
            if (str.equals(str2)) {
                return;
            }
            throw new MustacheParseException("Section close tag with mismatched open tag '" + str2 + "' != '" + str + "'", i3);
        }

        protected Accumulator addCloseSectionSegment(String str, int i3) {
            throw new MustacheParseException("Section close tag with no open tag '" + str + "'", i3);
        }

        public void addFauxSegment() {
            this._segs.add(new FauxSegment());
        }

        public Accumulator addTagSegment(StringBuilder sb5, final int i3) {
            String trim = sb5.toString().trim();
            final String trim2 = trim.substring(1).trim();
            sb5.setLength(0);
            char charAt = trim.charAt(0);
            if (charAt != '!') {
                if (charAt != '#') {
                    if (charAt != '&') {
                        if (charAt != '/') {
                            if (charAt != '>') {
                                if (charAt != '^') {
                                    requireNoNewlines(trim, i3);
                                    List<Template.Segment> list = this._segs;
                                    Compiler compiler = this._comp;
                                    list.add(new VariableSegment(trim, i3, compiler.formatter, compiler.escaper));
                                    return this;
                                }
                                requireNoNewlines(trim, i3);
                                return new Accumulator(this._comp, false) { // from class: com.samskivert.mustache.Mustache.Accumulator.2
                                    @Override // com.samskivert.mustache.Mustache.Accumulator
                                    protected Accumulator addCloseSectionSegment(String str, int i16) {
                                        Accumulator.requireSameName(trim2, str, i16);
                                        this._segs.add(new InvertedSegment(this._comp, str, super.finish(), i3));
                                        return this;
                                    }

                                    @Override // com.samskivert.mustache.Mustache.Accumulator
                                    public Template.Segment[] finish() {
                                        throw new MustacheParseException("Inverted section missing close tag '" + trim2 + "'", i3);
                                    }
                                };
                            }
                            this._segs.add(new IncludedTemplateSegment(this._comp, trim2));
                            return this;
                        }
                        requireNoNewlines(trim, i3);
                        return addCloseSectionSegment(trim2, i3);
                    }
                    requireNoNewlines(trim, i3);
                    this._segs.add(new VariableSegment(trim2, i3, this._comp.formatter, Escapers.NONE));
                    return this;
                }
                requireNoNewlines(trim, i3);
                return new Accumulator(this._comp, false) { // from class: com.samskivert.mustache.Mustache.Accumulator.1
                    @Override // com.samskivert.mustache.Mustache.Accumulator
                    protected Accumulator addCloseSectionSegment(String str, int i16) {
                        Accumulator.requireSameName(trim2, str, i16);
                        this._segs.add(new SectionSegment(this._comp, str, super.finish(), i3));
                        return this;
                    }

                    @Override // com.samskivert.mustache.Mustache.Accumulator
                    public Template.Segment[] finish() {
                        throw new MustacheParseException("Section missing close tag '" + trim2 + "'", i3);
                    }
                };
            }
            this._segs.add(new FauxSegment());
            return this;
        }

        public void addTextSegment(StringBuilder sb5) {
            boolean z16;
            if (sb5.length() > 0) {
                List<Template.Segment> list = this._segs;
                String sb6 = sb5.toString();
                if (this._segs.isEmpty() && this._topLevel) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                list.add(new StringSegment(sb6, z16));
                sb5.setLength(0);
            }
        }

        public Template.Segment[] finish() {
            List<Template.Segment> list = this._segs;
            return (Template.Segment[]) list.toArray(new Template.Segment[list.size()]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static abstract class BlockSegment extends NamedSegment {
        protected final Template.Segment[] _segs;

        protected BlockSegment(String str, Template.Segment[] segmentArr, int i3) {
            super(str, i3);
            this._segs = Mustache.trim(segmentArr, false);
        }

        protected void executeSegs(Template template, Template.Context context, Writer writer) {
            for (Template.Segment segment : this._segs) {
                segment.execute(template, context, writer);
            }
        }

        public boolean firstLeadsBlank() {
            Template.Segment[] segmentArr = this._segs;
            if (segmentArr.length != 0) {
                Template.Segment segment = segmentArr[0];
                if (segment instanceof StringSegment) {
                    return ((StringSegment) segment).leadsBlank();
                }
            }
            return false;
        }

        public boolean lastTrailsBlank() {
            Template.Segment[] segmentArr = this._segs;
            int length = segmentArr.length - 1;
            if (segmentArr.length != 0) {
                Template.Segment segment = segmentArr[length];
                if (segment instanceof StringSegment) {
                    return ((StringSegment) segment).trailsBlank();
                }
                return false;
            }
            return false;
        }

        public void trimFirstBlank() {
            Template.Segment[] segmentArr = this._segs;
            segmentArr[0] = ((StringSegment) segmentArr[0]).trimLeadBlank();
        }

        public void trimLastBlank() {
            Template.Segment[] segmentArr = this._segs;
            int length = segmentArr.length - 1;
            segmentArr[length] = ((StringSegment) segmentArr[length]).trimTrailBlank();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Collector {
        VariableFetcher createFetcher(Object obj, String str);

        <K, V> Map<K, V> createFetcherCache();

        Iterator<?> toIterator(Object obj);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Compiler {
        public final Collector collector;
        public final Delims delims;
        public final boolean emptyStringIsFalse;
        public final Escaper escaper;
        public final Formatter formatter;
        public final TemplateLoader loader;
        public final boolean missingIsNull;
        public final String nullValue;
        public final boolean standardsMode;
        public final boolean strictSections;
        public final boolean zeroIsFalse;

        protected Compiler(boolean z16, boolean z17, String str, boolean z18, boolean z19, boolean z26, Formatter formatter, Escaper escaper, TemplateLoader templateLoader, Collector collector, Delims delims) {
            this.standardsMode = z16;
            this.strictSections = z17;
            this.nullValue = str;
            this.missingIsNull = z18;
            this.emptyStringIsFalse = z19;
            this.zeroIsFalse = z26;
            this.formatter = formatter;
            this.escaper = escaper;
            this.loader = templateLoader;
            this.collector = collector;
            this.delims = delims;
        }

        public Template compile(String str) {
            return compile(new StringReader(str));
        }

        public String computeNullValue(String str) {
            String str2 = this.nullValue;
            if (str2 == null) {
                return null;
            }
            return str2.replace("{{name}}", str);
        }

        public Compiler defaultValue(String str) {
            return new Compiler(this.standardsMode, this.strictSections, str, true, this.emptyStringIsFalse, this.zeroIsFalse, this.formatter, this.escaper, this.loader, this.collector, this.delims);
        }

        public Compiler emptyStringIsFalse(boolean z16) {
            return new Compiler(this.standardsMode, this.strictSections, this.nullValue, this.missingIsNull, z16, this.zeroIsFalse, this.formatter, this.escaper, this.loader, this.collector, this.delims);
        }

        public Compiler escapeHTML(boolean z16) {
            Escaper escaper;
            if (z16) {
                escaper = Escapers.HTML;
            } else {
                escaper = Escapers.NONE;
            }
            return withEscaper(escaper);
        }

        public boolean isFalsey(Object obj) {
            if ((this.emptyStringIsFalse && "".equals(this.formatter.format(obj))) || (this.zeroIsFalse && (obj instanceof Number) && ((Number) obj).longValue() == 0)) {
                return true;
            }
            return false;
        }

        public Template loadTemplate(String str) throws MustacheException {
            Reader reader = null;
            try {
                try {
                    reader = this.loader.getTemplate(str);
                    Template compile = compile(reader);
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e16) {
                            throw new RuntimeException(e16);
                        }
                    }
                    return compile;
                } catch (Throwable th5) {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e17) {
                            throw new RuntimeException(e17);
                        }
                    }
                    throw th5;
                }
            } catch (Exception e18) {
                if (e18 instanceof RuntimeException) {
                    throw ((RuntimeException) e18);
                }
                throw new MustacheException("Unable to load template: " + str, e18);
            }
        }

        public Compiler nullValue(String str) {
            return new Compiler(this.standardsMode, this.strictSections, str, false, this.emptyStringIsFalse, this.zeroIsFalse, this.formatter, this.escaper, this.loader, this.collector, this.delims);
        }

        public Compiler standardsMode(boolean z16) {
            return new Compiler(z16, this.strictSections, this.nullValue, this.missingIsNull, this.emptyStringIsFalse, this.zeroIsFalse, this.formatter, this.escaper, this.loader, this.collector, this.delims);
        }

        public Compiler strictSections(boolean z16) {
            return new Compiler(this.standardsMode, z16, this.nullValue, this.missingIsNull, this.emptyStringIsFalse, this.zeroIsFalse, this.formatter, this.escaper, this.loader, this.collector, this.delims);
        }

        public Compiler withCollector(Collector collector) {
            return new Compiler(this.standardsMode, this.strictSections, this.nullValue, this.missingIsNull, this.emptyStringIsFalse, this.zeroIsFalse, this.formatter, this.escaper, this.loader, collector, this.delims);
        }

        public Compiler withDelims(String str) {
            return new Compiler(this.standardsMode, this.strictSections, this.nullValue, this.missingIsNull, this.emptyStringIsFalse, this.zeroIsFalse, this.formatter, this.escaper, this.loader, this.collector, new Delims().updateDelims(str));
        }

        public Compiler withEscaper(Escaper escaper) {
            return new Compiler(this.standardsMode, this.strictSections, this.nullValue, this.missingIsNull, this.emptyStringIsFalse, this.zeroIsFalse, this.formatter, escaper, this.loader, this.collector, this.delims);
        }

        public Compiler withFormatter(Formatter formatter) {
            return new Compiler(this.standardsMode, this.strictSections, this.nullValue, this.missingIsNull, this.emptyStringIsFalse, this.zeroIsFalse, formatter, this.escaper, this.loader, this.collector, this.delims);
        }

        public Compiler withLoader(TemplateLoader templateLoader) {
            return new Compiler(this.standardsMode, this.strictSections, this.nullValue, this.missingIsNull, this.emptyStringIsFalse, this.zeroIsFalse, this.formatter, this.escaper, templateLoader, this.collector, this.delims);
        }

        public Compiler zeroIsFalse(boolean z16) {
            return new Compiler(this.standardsMode, this.strictSections, this.nullValue, this.missingIsNull, this.emptyStringIsFalse, z16, this.formatter, this.escaper, this.loader, this.collector, this.delims);
        }

        public Template compile(Reader reader) {
            return Mustache.compile(reader, this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface CustomContext {
        Object get(String str) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Delims {
        public char start1 = '{';
        public char end1 = '}';
        public char start2 = '{';
        public char end2 = '}';

        protected Delims() {
        }

        private static String errmsg(String str) {
            return "Invalid delimiter configuration '" + str + "'. Must be of the form {{=1 2=}} or {{=12 34=}} where 1, 2, 3 and 4 are delimiter chars.";
        }

        public void addTag(char c16, String str, StringBuilder sb5) {
            sb5.append(this.start1);
            sb5.append(this.start2);
            if (c16 != ' ') {
                sb5.append(c16);
            }
            sb5.append(str);
            sb5.append(this.end1);
            sb5.append(this.end2);
        }

        Delims copy() {
            Delims delims = new Delims();
            delims.start1 = this.start1;
            delims.start2 = this.start2;
            delims.end1 = this.end1;
            delims.end2 = this.end2;
            return delims;
        }

        public boolean isStaches() {
            if (this.start1 == '{' && this.start2 == '{' && this.end1 == '}' && this.end2 == '}') {
                return true;
            }
            return false;
        }

        public Delims updateDelims(String str) {
            String[] split = str.split(" ");
            if (split.length == 2) {
                int length = split[0].length();
                if (length != 1) {
                    if (length == 2) {
                        this.start1 = split[0].charAt(0);
                        this.start2 = split[0].charAt(1);
                    } else {
                        throw new MustacheException(errmsg(str));
                    }
                } else {
                    this.start1 = split[0].charAt(0);
                    this.start2 = (char) 0;
                }
                int length2 = split[1].length();
                if (length2 != 1) {
                    if (length2 == 2) {
                        this.end1 = split[1].charAt(0);
                        this.end2 = split[1].charAt(1);
                    } else {
                        throw new MustacheException(errmsg(str));
                    }
                } else {
                    this.end1 = split[1].charAt(0);
                    this.end2 = (char) 0;
                }
                return this;
            }
            throw new MustacheException(errmsg(str));
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Escaper {
        String escape(String str);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Formatter {
        String format(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class IncludedTemplateSegment extends Template.Segment {
        protected final Compiler _comp;
        protected final String _name;
        private Template _template;

        public IncludedTemplateSegment(Compiler compiler, String str) {
            this._comp = compiler;
            this._name = str;
        }

        @Override // com.samskivert.mustache.Template.Segment
        public void decompile(Delims delims, StringBuilder sb5) {
            delims.addTag(Typography.greater, this._name, sb5);
        }

        @Override // com.samskivert.mustache.Template.Segment
        public void execute(Template template, Template.Context context, Writer writer) {
            getTemplate().executeSegs(context, writer);
        }

        protected Template getTemplate() {
            if (this._template == null) {
                this._template = this._comp.loadTemplate(this._name);
            }
            return this._template;
        }

        @Override // com.samskivert.mustache.Template.Segment
        public void visit(Visitor visitor) {
            if (visitor.visitInclude(this._name)) {
                getTemplate().visit(visitor);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    protected static class InvertedSegment extends BlockSegment {
        protected final Compiler _comp;

        public InvertedSegment(Compiler compiler, String str, Template.Segment[] segmentArr, int i3) {
            super(str, segmentArr, i3);
            this._comp = compiler;
        }

        @Override // com.samskivert.mustache.Template.Segment
        public void decompile(Delims delims, StringBuilder sb5) {
            delims.addTag('^', this._name, sb5);
            for (Template.Segment segment : this._segs) {
                segment.decompile(delims, sb5);
            }
            delims.addTag('/', this._name, sb5);
        }

        @Override // com.samskivert.mustache.Template.Segment
        public void execute(Template template, Template.Context context, Writer writer) {
            Object sectionValue = template.getSectionValue(context, this._name, this._line);
            Iterator<?> iterator = this._comp.collector.toIterator(sectionValue);
            if (iterator != null) {
                if (!iterator.hasNext()) {
                    executeSegs(template, context, writer);
                }
            } else if (sectionValue instanceof Boolean) {
                if (!((Boolean) sectionValue).booleanValue()) {
                    executeSegs(template, context, writer);
                }
            } else if (sectionValue instanceof InvertibleLambda) {
                try {
                    ((InvertibleLambda) sectionValue).executeInverse(template.createFragment(this._segs, context), writer);
                } catch (IOException e16) {
                    throw new MustacheException(e16);
                }
            } else if (this._comp.isFalsey(sectionValue)) {
                executeSegs(template, context, writer);
            }
        }

        public String toString() {
            return "Inverted(" + this._name + ":" + this._line + "): " + Arrays.toString(this._segs);
        }

        @Override // com.samskivert.mustache.Template.Segment
        public void visit(Visitor visitor) {
            if (visitor.visitInvertedSection(this._name)) {
                for (Template.Segment segment : this._segs) {
                    segment.visit(visitor);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface InvertibleLambda extends Lambda {
        void executeInverse(Template.Fragment fragment, Writer writer) throws IOException;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Lambda {
        void execute(Template.Fragment fragment, Writer writer) throws IOException;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    protected static abstract class NamedSegment extends Template.Segment {
        protected final int _line;
        protected final String _name;

        protected NamedSegment(String str, int i3) {
            this._name = str;
            this._line = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Parser {
        Accumulator accum;
        final Delims delims;
        Reader source;
        final StringBuilder text = new StringBuilder();
        int state = 0;
        int line = 1;
        int column = 0;
        int tagStartColumn = -1;

        public Parser(Compiler compiler) {
            this.accum = new Accumulator(compiler, true);
            this.delims = compiler.delims.copy();
        }

        protected int nextChar() {
            try {
                return this.source.read();
            } catch (IOException e16) {
                throw new MustacheException(e16);
            }
        }

        public Accumulator parse(Reader reader) {
            this.source = reader;
            while (true) {
                int nextChar = nextChar();
                if (nextChar == -1) {
                    break;
                }
                char c16 = (char) nextChar;
                this.column++;
                parseChar(c16);
                if (c16 == '\n') {
                    this.column = 0;
                    this.line++;
                }
            }
            int i3 = this.state;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        Mustache.restoreStartTag(this.text, this.delims);
                    }
                } else {
                    Mustache.restoreStartTag(this.text, this.delims);
                    this.text.append(this.delims.end1);
                }
            } else {
                this.text.append(this.delims.start1);
            }
            this.accum.addTextSegment(this.text);
            return this.accum;
        }

        protected void parseChar(char c16) {
            String valueOf;
            int i3 = this.state;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            Delims delims = this.delims;
                            if (c16 == delims.end1) {
                                this.state = 2;
                                if (delims.end2 == 0) {
                                    parseChar((char) 0);
                                    return;
                                }
                                return;
                            }
                            if (c16 == delims.start1 && this.text.length() > 0 && this.text.charAt(0) != '!') {
                                Mustache.restoreStartTag(this.text, this.delims);
                                this.accum.addTextSegment(this.text);
                                this.tagStartColumn = this.column;
                                if (this.delims.start2 == 0) {
                                    this.accum.addTextSegment(this.text);
                                    this.state = 3;
                                    return;
                                } else {
                                    this.state = 1;
                                    return;
                                }
                            }
                            this.text.append(c16);
                            return;
                        }
                        return;
                    }
                    Delims delims2 = this.delims;
                    if (c16 == delims2.end2) {
                        if (this.text.charAt(0) == '=') {
                            Delims delims3 = this.delims;
                            StringBuilder sb5 = this.text;
                            delims3.updateDelims(sb5.substring(1, sb5.length() - 1));
                            this.text.setLength(0);
                            this.accum.addFauxSegment();
                        } else {
                            if (this.delims.isStaches() && this.text.charAt(0) == this.delims.start1) {
                                int nextChar = nextChar();
                                if (nextChar != 125) {
                                    if (nextChar == -1) {
                                        valueOf = "";
                                    } else {
                                        valueOf = String.valueOf((char) nextChar);
                                    }
                                    throw new MustacheParseException("Invalid triple-mustache tag: {{" + ((Object) this.text) + "}}" + valueOf, this.line);
                                }
                                this.text.replace(0, 1, ContainerUtils.FIELD_DELIMITER);
                            }
                            this.accum = this.accum.addTagSegment(this.text, this.line);
                        }
                        this.state = 0;
                        return;
                    }
                    this.text.append(delims2.end1);
                    this.state = 3;
                    parseChar(c16);
                    return;
                }
                Delims delims4 = this.delims;
                if (c16 == delims4.start2) {
                    this.accum.addTextSegment(this.text);
                    this.state = 3;
                    return;
                } else {
                    this.text.append(delims4.start1);
                    this.state = 0;
                    parseChar(c16);
                    return;
                }
            }
            Delims delims5 = this.delims;
            if (c16 == delims5.start1) {
                this.state = 1;
                this.tagStartColumn = this.column;
                if (delims5.start2 == 0) {
                    parseChar((char) 0);
                    return;
                }
                return;
            }
            this.text.append(c16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    protected static class SectionSegment extends BlockSegment {
        protected final Compiler _comp;

        public SectionSegment(Compiler compiler, String str, Template.Segment[] segmentArr, int i3) {
            super(str, segmentArr, i3);
            this._comp = compiler;
        }

        @Override // com.samskivert.mustache.Template.Segment
        public void decompile(Delims delims, StringBuilder sb5) {
            delims.addTag('#', this._name, sb5);
            for (Template.Segment segment : this._segs) {
                segment.decompile(delims, sb5);
            }
            delims.addTag('/', this._name, sb5);
        }

        @Override // com.samskivert.mustache.Template.Segment
        public void execute(Template template, Template.Context context, Writer writer) {
            boolean z16;
            Object sectionValue = template.getSectionValue(context, this._name, this._line);
            Iterator<?> iterator = this._comp.collector.toIterator(sectionValue);
            if (iterator != null) {
                int i3 = 0;
                while (iterator.hasNext()) {
                    Object next = iterator.next();
                    if (i3 == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    i3++;
                    executeSegs(template, context.nest(next, i3, z16, true ^ iterator.hasNext()), writer);
                }
                return;
            }
            if (sectionValue instanceof Boolean) {
                if (((Boolean) sectionValue).booleanValue()) {
                    executeSegs(template, context, writer);
                }
            } else if (sectionValue instanceof Lambda) {
                try {
                    ((Lambda) sectionValue).execute(template.createFragment(this._segs, context), writer);
                } catch (IOException e16) {
                    throw new MustacheException(e16);
                }
            } else if (!this._comp.isFalsey(sectionValue)) {
                executeSegs(template, context.nest(sectionValue), writer);
            }
        }

        public String toString() {
            return "Section(" + this._name + ":" + this._line + "): " + Arrays.toString(this._segs);
        }

        @Override // com.samskivert.mustache.Template.Segment
        public void visit(Visitor visitor) {
            if (visitor.visitSection(this._name)) {
                for (Template.Segment segment : this._segs) {
                    segment.visit(visitor);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class StringSegment extends Template.Segment {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        protected final int _leadBlank;
        protected final String _text;
        protected final int _trailBlank;

        public StringSegment(String str, boolean z16) {
            this(str, blankPos(str, true, z16), blankPos(str, false, z16));
        }

        private static int blankPos(String str, boolean z16, boolean z17) {
            int i3;
            int i16;
            int length = str.length();
            if (z16) {
                i3 = 0;
            } else {
                i3 = length - 1;
            }
            if (!z16) {
                length = -1;
            }
            if (z16) {
                i16 = 1;
            } else {
                i16 = -1;
            }
            while (i3 != length) {
                char charAt = str.charAt(i3);
                if (charAt == '\n') {
                    if (!z16) {
                        return i3 + 1;
                    }
                    return i3;
                }
                if (!Character.isWhitespace(charAt)) {
                    return -1;
                }
                i3 += i16;
            }
            if (!z16 && z17) {
                return 0;
            }
            return -1;
        }

        @Override // com.samskivert.mustache.Template.Segment
        public void decompile(Delims delims, StringBuilder sb5) {
            sb5.append(this._text);
        }

        @Override // com.samskivert.mustache.Template.Segment
        public void execute(Template template, Template.Context context, Writer writer) {
            Template.Segment.write(writer, this._text);
        }

        public boolean leadsBlank() {
            if (this._leadBlank != -1) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "Text(" + this._text.replace("\r", "\\r").replace("\n", RedTouch.NEWLINE_CHAR) + ")" + this._leadBlank + "/" + this._trailBlank;
        }

        public boolean trailsBlank() {
            if (this._trailBlank != -1) {
                return true;
            }
            return false;
        }

        public StringSegment trimLeadBlank() {
            int i3;
            int i16 = this._leadBlank;
            if (i16 == -1) {
                return this;
            }
            int i17 = i16 + 1;
            int i18 = this._trailBlank;
            if (i18 == -1) {
                i3 = -1;
            } else {
                i3 = i18 - i17;
            }
            return new StringSegment(this._text.substring(i17), -1, i3);
        }

        public StringSegment trimTrailBlank() {
            int i3 = this._trailBlank;
            if (i3 == -1) {
                return this;
            }
            return new StringSegment(this._text.substring(0, i3), this._leadBlank, -1);
        }

        @Override // com.samskivert.mustache.Template.Segment
        public void visit(Visitor visitor) {
            visitor.visitText(this._text);
        }

        public StringSegment(String str, int i3, int i16) {
            this._text = str;
            this._leadBlank = i3;
            this._trailBlank = i16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface TemplateLoader {
        Reader getTemplate(String str) throws Exception;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface VariableFetcher {
        Object get(Object obj, String str) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class VariableSegment extends NamedSegment {
        protected final Escaper _escaper;
        protected final Formatter _formatter;

        public VariableSegment(String str, int i3, Formatter formatter, Escaper escaper) {
            super(str, i3);
            this._formatter = formatter;
            this._escaper = escaper;
        }

        @Override // com.samskivert.mustache.Template.Segment
        public void decompile(Delims delims, StringBuilder sb5) {
            delims.addTag(TokenParser.SP, this._name, sb5);
        }

        @Override // com.samskivert.mustache.Template.Segment
        public void execute(Template template, Template.Context context, Writer writer) {
            StringBuilder sb5;
            String str;
            Object valueOrDefault = template.getValueOrDefault(context, this._name, this._line);
            if (valueOrDefault == null) {
                if (Template.isThisName(this._name)) {
                    sb5 = new StringBuilder();
                    str = "Resolved '.' to null (which is disallowed), on line ";
                } else {
                    sb5 = new StringBuilder();
                    sb5.append("No key, method or field with name '");
                    sb5.append(this._name);
                    str = "' on line ";
                }
                sb5.append(str);
                sb5.append(this._line);
                throw new MustacheException.Context(sb5.toString(), this._name, this._line);
            }
            Template.Segment.write(writer, this._escaper.escape(this._formatter.format(valueOrDefault)));
        }

        public String toString() {
            return "Var(" + this._name + ":" + this._line + ")";
        }

        @Override // com.samskivert.mustache.Template.Segment
        public void visit(Visitor visitor) {
            visitor.visitVariable(this._name);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Visitor {
        boolean visitInclude(String str);

        boolean visitInvertedSection(String str);

        boolean visitSection(String str);

        void visitText(String str);

        void visitVariable(String str);
    }

    Mustache() {
    }

    protected static boolean allowsWhitespace(char c16) {
        if (c16 != '=' && c16 != '!') {
            return false;
        }
        return true;
    }

    protected static Template compile(Reader reader, Compiler compiler) {
        return new Template(trim(new Parser(compiler).parse(reader).finish(), true), compiler);
    }

    public static Compiler compiler() {
        return new Compiler(false, false, null, false, false, false, DEFAULT_FORMATTER, Escapers.HTML, FAILING_LOADER, new DefaultCollector(), new Delims());
    }

    protected static void restoreStartTag(StringBuilder sb5, Delims delims) {
        sb5.insert(0, delims.start1);
        char c16 = delims.start2;
        if (c16 != 0) {
            sb5.insert(1, c16);
        }
    }

    protected static Template.Segment[] trim(Template.Segment[] segmentArr, boolean z16) {
        Template.Segment segment;
        Template.Segment segment2;
        StringSegment stringSegment;
        boolean z17;
        int length = segmentArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            Template.Segment segment3 = segmentArr[i3];
            StringSegment stringSegment2 = null;
            if (i3 > 0) {
                segment = segmentArr[i3 - 1];
            } else {
                segment = null;
            }
            if (i3 < length - 1) {
                segment2 = segmentArr[i3 + 1];
            } else {
                segment2 = null;
            }
            if (segment instanceof StringSegment) {
                stringSegment = (StringSegment) segment;
            } else {
                stringSegment = null;
            }
            if (segment2 instanceof StringSegment) {
                stringSegment2 = (StringSegment) segment2;
            }
            boolean z18 = true;
            if ((segment == null && z16) || (stringSegment != null && stringSegment.trailsBlank())) {
                z17 = true;
            } else {
                z17 = false;
            }
            if ((segment2 != null || !z16) && (stringSegment2 == null || !stringSegment2.leadsBlank())) {
                z18 = false;
            }
            if (segment3 instanceof BlockSegment) {
                BlockSegment blockSegment = (BlockSegment) segment3;
                if (z17 && blockSegment.firstLeadsBlank()) {
                    if (segment != null) {
                        segmentArr[i3 - 1] = stringSegment.trimTrailBlank();
                    }
                    blockSegment.trimFirstBlank();
                }
                if (z18 && blockSegment.lastTrailsBlank()) {
                    blockSegment.trimLastBlank();
                    if (segment2 != null) {
                        segmentArr[i3 + 1] = stringSegment2.trimLeadBlank();
                    }
                }
            } else if ((segment3 instanceof FauxSegment) && z17 && z18) {
                if (segment != null) {
                    segmentArr[i3 - 1] = stringSegment.trimTrailBlank();
                }
                if (segment2 != null) {
                    segmentArr[i3 + 1] = stringSegment2.trimLeadBlank();
                }
            }
        }
        return segmentArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class FauxSegment extends Template.Segment {
        protected FauxSegment() {
        }

        public String toString() {
            return "Faux";
        }

        @Override // com.samskivert.mustache.Template.Segment
        public void visit(Visitor visitor) {
        }

        @Override // com.samskivert.mustache.Template.Segment
        public void decompile(Delims delims, StringBuilder sb5) {
        }

        @Override // com.samskivert.mustache.Template.Segment
        public void execute(Template template, Template.Context context, Writer writer) {
        }
    }
}
