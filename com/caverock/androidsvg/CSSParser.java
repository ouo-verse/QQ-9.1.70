package com.caverock.androidsvg;

import android.util.Log;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParser;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.text.Typography;
import org.apache.httpcore.message.TokenParser;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public class CSSParser {
    private static final String CLASS = "class";
    private static final String ID = "id";
    private static final String TAG = "AndroidSVG CSSParser";
    private boolean inMediaRule = false;
    private MediaType rendererMediaType;

    /* loaded from: classes.dex */
    public static class Attrib {
        public String name;
        public AttribOp operation;
        public String value;

        public Attrib(String str, AttribOp attribOp, String str2) {
            this.name = str;
            this.operation = attribOp;
            this.value = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum AttribOp {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static AttribOp[] valuesCustom() {
            AttribOp[] valuesCustom = values();
            int length = valuesCustom.length;
            AttribOp[] attribOpArr = new AttribOp[length];
            System.arraycopy(valuesCustom, 0, attribOpArr, 0, length);
            return attribOpArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CSSTextScanner extends SVGParser.TextScanner {
        public CSSTextScanner(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        private String nextAttribValue() {
            if (empty()) {
                return null;
            }
            String nextQuotedString = nextQuotedString();
            if (nextQuotedString != null) {
                return nextQuotedString;
            }
            return nextIdentifier();
        }

        private int scanForIdentifier() {
            int i3;
            if (empty()) {
                return this.position;
            }
            int i16 = this.position;
            int charAt = this.input.charAt(i16);
            if (charAt == 45) {
                charAt = advanceChar();
            }
            if ((charAt >= 65 && charAt <= 90) || ((charAt >= 97 && charAt <= 122) || charAt == 95)) {
                int advanceChar = advanceChar();
                while (true) {
                    if ((advanceChar < 65 || advanceChar > 90) && ((advanceChar < 97 || advanceChar > 122) && !((advanceChar >= 48 && advanceChar <= 57) || advanceChar == 45 || advanceChar == 95))) {
                        break;
                    }
                    advanceChar = advanceChar();
                }
                i3 = this.position;
            } else {
                i3 = i16;
            }
            this.position = i16;
            return i3;
        }

        public String nextIdentifier() {
            int scanForIdentifier = scanForIdentifier();
            int i3 = this.position;
            if (scanForIdentifier == i3) {
                return null;
            }
            String substring = this.input.substring(i3, scanForIdentifier);
            this.position = scanForIdentifier;
            return substring;
        }

        public String nextPropertyValue() {
            if (empty()) {
                return null;
            }
            int i3 = this.position;
            int charAt = this.input.charAt(i3);
            int i16 = i3;
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !isEOL(charAt)) {
                if (!isWhitespace(charAt)) {
                    i16 = this.position + 1;
                }
                charAt = advanceChar();
            }
            if (this.position > i3) {
                return this.input.substring(i3, i16);
            }
            this.position = i3;
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x015f  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0163  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x015d A[EDGE_INSN: B:94:0x015d->B:78:0x015d BREAK  A[LOOP:0: B:14:0x004d->B:47:0x004d], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:95:0x003c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean nextSimpleSelector(Selector selector) throws SAXException {
            Combinator combinator;
            SimpleSelector simpleSelector;
            AttribOp attribOp;
            String str;
            if (empty()) {
                return false;
            }
            int i3 = this.position;
            if (!selector.isEmpty()) {
                if (consume(Typography.greater)) {
                    combinator = Combinator.CHILD;
                    skipWhitespace();
                } else if (consume('+')) {
                    combinator = Combinator.FOLLOWS;
                    skipWhitespace();
                }
                if (!consume('*')) {
                    simpleSelector = new SimpleSelector(combinator, null);
                } else {
                    String nextIdentifier = nextIdentifier();
                    if (nextIdentifier != null) {
                        SimpleSelector simpleSelector2 = new SimpleSelector(combinator, nextIdentifier);
                        selector.addedElement();
                        simpleSelector = simpleSelector2;
                    } else {
                        simpleSelector = null;
                    }
                }
                while (true) {
                    if (!empty()) {
                        if (consume('.')) {
                            if (simpleSelector == null) {
                                simpleSelector = new SimpleSelector(combinator, null);
                            }
                            String nextIdentifier2 = nextIdentifier();
                            if (nextIdentifier2 != null) {
                                simpleSelector.addAttrib("class", AttribOp.EQUALS, nextIdentifier2);
                                selector.addedAttributeOrPseudo();
                            } else {
                                throw new SAXException("Invalid \".class\" selector in <style> element");
                            }
                        } else {
                            if (consume('#')) {
                                if (simpleSelector == null) {
                                    simpleSelector = new SimpleSelector(combinator, null);
                                }
                                String nextIdentifier3 = nextIdentifier();
                                if (nextIdentifier3 != null) {
                                    simpleSelector.addAttrib("id", AttribOp.EQUALS, nextIdentifier3);
                                    selector.addedIdAttribute();
                                } else {
                                    throw new SAXException("Invalid \"#id\" selector in <style> element");
                                }
                            }
                            if (simpleSelector == null) {
                                break;
                            }
                            if (consume('[')) {
                                skipWhitespace();
                                String nextIdentifier4 = nextIdentifier();
                                if (nextIdentifier4 != null) {
                                    skipWhitespace();
                                    if (consume('=')) {
                                        attribOp = AttribOp.EQUALS;
                                    } else if (consume("~=")) {
                                        attribOp = AttribOp.INCLUDES;
                                    } else if (consume("|=")) {
                                        attribOp = AttribOp.DASHMATCH;
                                    } else {
                                        attribOp = null;
                                    }
                                    if (attribOp != null) {
                                        skipWhitespace();
                                        str = nextAttribValue();
                                        if (str != null) {
                                            skipWhitespace();
                                        } else {
                                            throw new SAXException("Invalid attribute selector in <style> element");
                                        }
                                    } else {
                                        str = null;
                                    }
                                    if (consume(']')) {
                                        if (attribOp == null) {
                                            attribOp = AttribOp.EXISTS;
                                        }
                                        simpleSelector.addAttrib(nextIdentifier4, attribOp, str);
                                        selector.addedAttributeOrPseudo();
                                    } else {
                                        throw new SAXException("Invalid attribute selector in <style> element");
                                    }
                                } else {
                                    throw new SAXException("Invalid attribute selector in <style> element");
                                }
                            } else if (consume(':')) {
                                int i16 = this.position;
                                if (nextIdentifier() != null) {
                                    if (consume('(')) {
                                        skipWhitespace();
                                        if (nextIdentifier() != null) {
                                            skipWhitespace();
                                            if (!consume(')')) {
                                                this.position = i16 - 1;
                                            }
                                        }
                                    }
                                    simpleSelector.addPseudo(this.input.substring(i16, this.position));
                                    selector.addedAttributeOrPseudo();
                                }
                            }
                        }
                    } else {
                        break;
                    }
                }
                if (simpleSelector == null) {
                    selector.add(simpleSelector);
                    return true;
                }
                this.position = i3;
                return false;
            }
            combinator = null;
            if (!consume('*')) {
            }
            while (true) {
                if (!empty()) {
                }
            }
            if (simpleSelector == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum Combinator {
        DESCENDANT,
        CHILD,
        FOLLOWS;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Combinator[] valuesCustom() {
            Combinator[] valuesCustom = values();
            int length = valuesCustom.length;
            Combinator[] combinatorArr = new Combinator[length];
            System.arraycopy(valuesCustom, 0, combinatorArr, 0, length);
            return combinatorArr;
        }
    }

    /* loaded from: classes.dex */
    public enum MediaType {
        all,
        aural,
        braille,
        embossed,
        handheld,
        print,
        projection,
        screen,
        tty,
        tv;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static MediaType[] valuesCustom() {
            MediaType[] valuesCustom = values();
            int length = valuesCustom.length;
            MediaType[] mediaTypeArr = new MediaType[length];
            System.arraycopy(valuesCustom, 0, mediaTypeArr, 0, length);
            return mediaTypeArr;
        }
    }

    /* loaded from: classes.dex */
    public static class Rule {
        public Selector selector;
        public SVG.Style style;

        public Rule(Selector selector, SVG.Style style) {
            this.selector = selector;
            this.style = style;
        }

        public String toString() {
            return this.selector + " {}";
        }
    }

    /* loaded from: classes.dex */
    public static class Ruleset {
        private List<Rule> rules = null;

        public void add(Rule rule) {
            if (this.rules == null) {
                this.rules = new ArrayList();
            }
            for (int i3 = 0; i3 < this.rules.size(); i3++) {
                if (this.rules.get(i3).selector.specificity > rule.selector.specificity) {
                    this.rules.add(i3, rule);
                    return;
                }
            }
            this.rules.add(rule);
        }

        public void addAll(Ruleset ruleset) {
            if (ruleset.rules == null) {
                return;
            }
            if (this.rules == null) {
                this.rules = new ArrayList(ruleset.rules.size());
            }
            Iterator<Rule> it = ruleset.rules.iterator();
            while (it.hasNext()) {
                this.rules.add(it.next());
            }
        }

        public List<Rule> getRules() {
            return this.rules;
        }

        public boolean isEmpty() {
            List<Rule> list = this.rules;
            if (list != null && !list.isEmpty()) {
                return false;
            }
            return true;
        }

        public String toString() {
            if (this.rules == null) {
                return "";
            }
            StringBuilder sb5 = new StringBuilder();
            Iterator<Rule> it = this.rules.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().toString());
                sb5.append('\n');
            }
            return sb5.toString();
        }
    }

    /* loaded from: classes.dex */
    public static class Selector {
        public List<SimpleSelector> selector = null;
        public int specificity = 0;

        public void add(SimpleSelector simpleSelector) {
            if (this.selector == null) {
                this.selector = new ArrayList();
            }
            this.selector.add(simpleSelector);
        }

        public void addedAttributeOrPseudo() {
            this.specificity += 100;
        }

        public void addedElement() {
            this.specificity++;
        }

        public void addedIdAttribute() {
            this.specificity += 10000;
        }

        public SimpleSelector get(int i3) {
            return this.selector.get(i3);
        }

        public boolean isEmpty() {
            List<SimpleSelector> list = this.selector;
            if (list == null) {
                return true;
            }
            return list.isEmpty();
        }

        public int size() {
            List<SimpleSelector> list = this.selector;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            Iterator<SimpleSelector> it = this.selector.iterator();
            while (it.hasNext()) {
                sb5.append(it.next());
                sb5.append(TokenParser.SP);
            }
            sb5.append('(');
            sb5.append(this.specificity);
            sb5.append(')');
            return sb5.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SimpleSelector {
        private static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$CSSParser$AttribOp;
        public Combinator combinator;
        public String tag;
        public List<Attrib> attribs = null;
        public List<String> pseudos = null;

        static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$CSSParser$AttribOp() {
            int[] iArr = $SWITCH_TABLE$com$caverock$androidsvg$CSSParser$AttribOp;
            if (iArr != null) {
                return iArr;
            }
            int[] iArr2 = new int[AttribOp.valuesCustom().length];
            try {
                iArr2[AttribOp.DASHMATCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr2[AttribOp.EQUALS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[AttribOp.EXISTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[AttribOp.INCLUDES.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            $SWITCH_TABLE$com$caverock$androidsvg$CSSParser$AttribOp = iArr2;
            return iArr2;
        }

        public SimpleSelector(Combinator combinator, String str) {
            this.combinator = null;
            this.tag = null;
            this.combinator = combinator == null ? Combinator.DESCENDANT : combinator;
            this.tag = str;
        }

        public void addAttrib(String str, AttribOp attribOp, String str2) {
            if (this.attribs == null) {
                this.attribs = new ArrayList();
            }
            this.attribs.add(new Attrib(str, attribOp, str2));
        }

        public void addPseudo(String str) {
            if (this.pseudos == null) {
                this.pseudos = new ArrayList();
            }
            this.pseudos.add(str);
        }

        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            Combinator combinator = this.combinator;
            if (combinator == Combinator.CHILD) {
                sb5.append("> ");
            } else if (combinator == Combinator.FOLLOWS) {
                sb5.append("+ ");
            }
            String str = this.tag;
            if (str == null) {
                str = "*";
            }
            sb5.append(str);
            List<Attrib> list = this.attribs;
            if (list != null) {
                for (Attrib attrib : list) {
                    sb5.append('[');
                    sb5.append(attrib.name);
                    int i3 = $SWITCH_TABLE$com$caverock$androidsvg$CSSParser$AttribOp()[attrib.operation.ordinal()];
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                sb5.append("|=");
                                sb5.append(attrib.value);
                            }
                        } else {
                            sb5.append("~=");
                            sb5.append(attrib.value);
                        }
                    } else {
                        sb5.append('=');
                        sb5.append(attrib.value);
                    }
                    sb5.append(']');
                }
            }
            List<String> list2 = this.pseudos;
            if (list2 != null) {
                for (String str2 : list2) {
                    sb5.append(':');
                    sb5.append(str2);
                }
            }
            return sb5.toString();
        }
    }

    public CSSParser(MediaType mediaType) {
        this.rendererMediaType = mediaType;
    }

    private static int getChildPosition(List<SVG.SvgContainer> list, int i3, SVG.SvgElementBase svgElementBase) {
        if (i3 < 0) {
            return -1;
        }
        SVG.SvgContainer svgContainer = list.get(i3);
        SVG.SvgContainer svgContainer2 = svgElementBase.parent;
        if (svgContainer != svgContainer2) {
            return -1;
        }
        Iterator<SVG.SvgObject> it = svgContainer2.getChildren().iterator();
        int i16 = 0;
        while (it.hasNext()) {
            if (it.next() == svgElementBase) {
                return i16;
            }
            i16++;
        }
        return -1;
    }

    public static boolean mediaMatches(String str, MediaType mediaType) throws SAXException {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        cSSTextScanner.skipWhitespace();
        List<MediaType> parseMediaList = parseMediaList(cSSTextScanner);
        if (cSSTextScanner.empty()) {
            return mediaMatches(parseMediaList, mediaType);
        }
        throw new SAXException("Invalid @media type list");
    }

    private void parseAtRule(Ruleset ruleset, CSSTextScanner cSSTextScanner) throws SAXException {
        String nextIdentifier = cSSTextScanner.nextIdentifier();
        cSSTextScanner.skipWhitespace();
        if (nextIdentifier != null) {
            if (!this.inMediaRule && nextIdentifier.equals(QAdVrReportParams.ParamKey.MEDIA)) {
                List<MediaType> parseMediaList = parseMediaList(cSSTextScanner);
                if (cSSTextScanner.consume('{')) {
                    cSSTextScanner.skipWhitespace();
                    if (mediaMatches(parseMediaList, this.rendererMediaType)) {
                        this.inMediaRule = true;
                        ruleset.addAll(parseRuleset(cSSTextScanner));
                        this.inMediaRule = false;
                    } else {
                        parseRuleset(cSSTextScanner);
                    }
                    if (!cSSTextScanner.consume('}')) {
                        throw new SAXException("Invalid @media rule: expected '}' at end of rule set");
                    }
                } else {
                    throw new SAXException("Invalid @media rule: missing rule set");
                }
            } else {
                warn("Ignoring @%s rule", nextIdentifier);
                skipAtRule(cSSTextScanner);
            }
            cSSTextScanner.skipWhitespace();
            return;
        }
        throw new SAXException("Invalid '@' rule in <style> element");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static List<String> parseClassAttribute(String str) throws SAXException {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        ArrayList arrayList = null;
        while (!cSSTextScanner.empty()) {
            String nextIdentifier = cSSTextScanner.nextIdentifier();
            if (nextIdentifier != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(nextIdentifier);
                cSSTextScanner.skipWhitespace();
            } else {
                throw new SAXException("Invalid value for \"class\" attribute: " + str);
            }
        }
        return arrayList;
    }

    private SVG.Style parseDeclarations(CSSTextScanner cSSTextScanner) throws SAXException {
        SVG.Style style = new SVG.Style();
        do {
            String nextIdentifier = cSSTextScanner.nextIdentifier();
            cSSTextScanner.skipWhitespace();
            if (!cSSTextScanner.consume(':')) {
                break;
            }
            cSSTextScanner.skipWhitespace();
            String nextPropertyValue = cSSTextScanner.nextPropertyValue();
            if (nextPropertyValue == null) {
                break;
            }
            cSSTextScanner.skipWhitespace();
            if (cSSTextScanner.consume('!')) {
                cSSTextScanner.skipWhitespace();
                if (cSSTextScanner.consume("important")) {
                    cSSTextScanner.skipWhitespace();
                } else {
                    throw new SAXException("Malformed rule set in <style> element: found unexpected '!'");
                }
            }
            cSSTextScanner.consume(';');
            SVGParser.processStyleProperty(style, nextIdentifier, nextPropertyValue);
            cSSTextScanner.skipWhitespace();
            if (cSSTextScanner.consume('}')) {
                return style;
            }
        } while (!cSSTextScanner.empty());
        throw new SAXException("Malformed rule set in <style> element");
    }

    private static List<MediaType> parseMediaList(CSSTextScanner cSSTextScanner) throws SAXException {
        ArrayList arrayList = new ArrayList();
        while (!cSSTextScanner.empty()) {
            try {
                arrayList.add(MediaType.valueOf(cSSTextScanner.nextToken(',')));
                if (!cSSTextScanner.skipCommaWhitespace()) {
                    break;
                }
            } catch (IllegalArgumentException unused) {
                throw new SAXException("Invalid @media type list");
            }
        }
        return arrayList;
    }

    private boolean parseRule(Ruleset ruleset, CSSTextScanner cSSTextScanner) throws SAXException {
        List<Selector> parseSelectorGroup = parseSelectorGroup(cSSTextScanner);
        if (parseSelectorGroup != null && !parseSelectorGroup.isEmpty()) {
            if (cSSTextScanner.consume('{')) {
                cSSTextScanner.skipWhitespace();
                SVG.Style parseDeclarations = parseDeclarations(cSSTextScanner);
                cSSTextScanner.skipWhitespace();
                Iterator<Selector> it = parseSelectorGroup.iterator();
                while (it.hasNext()) {
                    ruleset.add(new Rule(it.next(), parseDeclarations));
                }
                return true;
            }
            throw new SAXException("Malformed rule block in <style> element: missing '{'");
        }
        return false;
    }

    private Ruleset parseRuleset(CSSTextScanner cSSTextScanner) throws SAXException {
        Ruleset ruleset = new Ruleset();
        while (!cSSTextScanner.empty()) {
            if (!cSSTextScanner.consume("<!--") && !cSSTextScanner.consume("-->")) {
                if (cSSTextScanner.consume('@')) {
                    parseAtRule(ruleset, cSSTextScanner);
                } else if (!parseRule(ruleset, cSSTextScanner)) {
                    break;
                }
            }
        }
        return ruleset;
    }

    private List<Selector> parseSelectorGroup(CSSTextScanner cSSTextScanner) throws SAXException {
        if (cSSTextScanner.empty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        Selector selector = new Selector();
        while (!cSSTextScanner.empty() && cSSTextScanner.nextSimpleSelector(selector)) {
            if (cSSTextScanner.skipCommaWhitespace()) {
                arrayList.add(selector);
                selector = new Selector();
            }
        }
        if (!selector.isEmpty()) {
            arrayList.add(selector);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean ruleMatch(Selector selector, SVG.SvgElementBase svgElementBase) {
        ArrayList arrayList = new ArrayList();
        for (Object obj = svgElementBase.parent; obj != null; obj = ((SVG.SvgObject) obj).parent) {
            arrayList.add(0, obj);
        }
        int size = arrayList.size() - 1;
        if (selector.size() == 1) {
            return selectorMatch(selector.get(0), arrayList, size, svgElementBase);
        }
        return ruleMatch(selector, selector.size() - 1, arrayList, size, svgElementBase);
    }

    private static boolean ruleMatchOnAncestors(Selector selector, int i3, List<SVG.SvgContainer> list, int i16) {
        SimpleSelector simpleSelector = selector.get(i3);
        SVG.SvgElementBase svgElementBase = (SVG.SvgElementBase) list.get(i16);
        if (!selectorMatch(simpleSelector, list, i16, svgElementBase)) {
            return false;
        }
        Combinator combinator = simpleSelector.combinator;
        if (combinator == Combinator.DESCENDANT) {
            if (i3 == 0) {
                return true;
            }
            while (i16 > 0) {
                i16--;
                if (ruleMatchOnAncestors(selector, i3 - 1, list, i16)) {
                    return true;
                }
            }
            return false;
        }
        if (combinator == Combinator.CHILD) {
            return ruleMatchOnAncestors(selector, i3 - 1, list, i16 - 1);
        }
        int childPosition = getChildPosition(list, i16, svgElementBase);
        if (childPosition <= 0) {
            return false;
        }
        return ruleMatch(selector, i3 - 1, list, i16, (SVG.SvgElementBase) svgElementBase.parent.getChildren().get(childPosition - 1));
    }

    private static boolean selectorMatch(SimpleSelector simpleSelector, List<SVG.SvgContainer> list, int i3, SVG.SvgElementBase svgElementBase) {
        List<String> list2;
        String str = simpleSelector.tag;
        if (str != null) {
            if (str.equalsIgnoreCase("G")) {
                if (!(svgElementBase instanceof SVG.Group)) {
                    return false;
                }
            } else if (!simpleSelector.tag.equals(svgElementBase.getClass().getSimpleName().toLowerCase(Locale.US))) {
                return false;
            }
        }
        List<Attrib> list3 = simpleSelector.attribs;
        if (list3 != null) {
            for (Attrib attrib : list3) {
                String str2 = attrib.name;
                if (str2 == "id") {
                    if (!attrib.value.equals(svgElementBase.f31971id)) {
                        return false;
                    }
                } else if (str2 != "class" || (list2 = svgElementBase.classNames) == null || !list2.contains(attrib.value)) {
                    return false;
                }
            }
        }
        List<String> list4 = simpleSelector.pseudos;
        if (list4 != null) {
            Iterator<String> it = list4.iterator();
            while (it.hasNext()) {
                if (!it.next().equals("first-child") || getChildPosition(list, i3, svgElementBase) != 0) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    private void skipAtRule(CSSTextScanner cSSTextScanner) {
        int i3 = 0;
        while (!cSSTextScanner.empty()) {
            int intValue = cSSTextScanner.nextChar().intValue();
            if (intValue == 59 && i3 == 0) {
                return;
            }
            if (intValue == 123) {
                i3++;
            } else if (intValue == 125 && i3 > 0 && i3 - 1 == 0) {
                return;
            }
        }
    }

    private static void warn(String str, Object... objArr) {
        Log.w(TAG, String.format(str, objArr));
    }

    public Ruleset parse(String str) throws SAXException {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        cSSTextScanner.skipWhitespace();
        return parseRuleset(cSSTextScanner);
    }

    private static boolean mediaMatches(List<MediaType> list, MediaType mediaType) {
        for (MediaType mediaType2 : list) {
            if (mediaType2 == MediaType.all || mediaType2 == mediaType) {
                return true;
            }
        }
        return false;
    }

    private static boolean ruleMatch(Selector selector, int i3, List<SVG.SvgContainer> list, int i16, SVG.SvgElementBase svgElementBase) {
        SimpleSelector simpleSelector = selector.get(i3);
        if (!selectorMatch(simpleSelector, list, i16, svgElementBase)) {
            return false;
        }
        Combinator combinator = simpleSelector.combinator;
        if (combinator == Combinator.DESCENDANT) {
            if (i3 == 0) {
                return true;
            }
            while (i16 >= 0) {
                if (ruleMatchOnAncestors(selector, i3 - 1, list, i16)) {
                    return true;
                }
                i16--;
            }
            return false;
        }
        if (combinator == Combinator.CHILD) {
            return ruleMatchOnAncestors(selector, i3 - 1, list, i16);
        }
        int childPosition = getChildPosition(list, i16, svgElementBase);
        if (childPosition <= 0) {
            return false;
        }
        return ruleMatch(selector, i3 - 1, list, i16, (SVG.SvgElementBase) svgElementBase.parent.getChildren().get(childPosition - 1));
    }
}
