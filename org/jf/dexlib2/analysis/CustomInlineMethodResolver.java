package org.jf.dexlib2.analysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.Method;
import org.jf.dexlib2.iface.MethodImplementation;
import org.jf.dexlib2.iface.instruction.InlineIndexInstruction;
import org.jf.dexlib2.immutable.ImmutableMethod;
import org.jf.dexlib2.immutable.ImmutableMethodParameter;
import org.jf.dexlib2.immutable.reference.ImmutableMethodReference;
import org.jf.dexlib2.immutable.util.ParamUtil;
import q1.g;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CustomInlineMethodResolver extends InlineMethodResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Pattern longMethodPattern = Pattern.compile("(L[^;]+;)->([^(]+)\\(([^)]*)\\)(.+)");

    @Nonnull
    private final ClassPath classPath;

    @Nonnull
    private final Method[] inlineMethods;

    public CustomInlineMethodResolver(@Nonnull ClassPath classPath, @Nonnull String str) {
        this.classPath = classPath;
        StringReader stringReader = new StringReader(str);
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(stringReader);
        try {
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                if (readLine.length() > 0) {
                    arrayList.add(readLine);
                }
            }
            this.inlineMethods = new Method[arrayList.size()];
            int i3 = 0;
            while (true) {
                Method[] methodArr = this.inlineMethods;
                if (i3 >= methodArr.length) {
                    return;
                }
                methodArr[i3] = parseAndResolveInlineMethod((String) arrayList.get(i3));
                i3++;
            }
        } catch (IOException e16) {
            throw new RuntimeException("Error while parsing inline table", e16);
        }
    }

    @Nonnull
    private Method parseAndResolveInlineMethod(@Nonnull String str) {
        int i3;
        Matcher matcher = longMethodPattern.matcher(str);
        if (matcher.matches()) {
            boolean z16 = true;
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            Iterable<ImmutableMethodParameter> parseParamString = ParamUtil.parseParamString(matcher.group(3));
            String group3 = matcher.group(4);
            ImmutableMethodReference immutableMethodReference = new ImmutableMethodReference(group, group2, parseParamString, group3);
            TypeProto typeProto = this.classPath.getClass(group);
            if (typeProto instanceof ClassProto) {
                for (Method method : ((ClassProto) typeProto).getClassDef().getMethods()) {
                    if (method.equals(immutableMethodReference)) {
                        i3 = method.getAccessFlags();
                        break;
                    }
                }
            }
            z16 = false;
            i3 = 0;
            if (z16) {
                return new ImmutableMethod(group, group2, parseParamString, group3, i3, (Set<? extends Annotation>) null, (Set<HiddenApiRestriction>) null, (MethodImplementation) null);
            }
            throw new RuntimeException("Cannot resolve inline method: " + str);
        }
        throw new RuntimeException("Invalid method descriptor: " + str);
    }

    @Override // org.jf.dexlib2.analysis.InlineMethodResolver
    @Nonnull
    public Method resolveExecuteInline(@Nonnull AnalyzedInstruction analyzedInstruction) {
        int inlineIndex = ((InlineIndexInstruction) analyzedInstruction.instruction).getInlineIndex();
        if (inlineIndex >= 0) {
            Method[] methodArr = this.inlineMethods;
            if (inlineIndex < methodArr.length) {
                return methodArr[inlineIndex];
            }
        }
        throw new RuntimeException("Invalid method index: " + inlineIndex);
    }

    public CustomInlineMethodResolver(@Nonnull ClassPath classPath, @Nonnull File file) throws IOException {
        this(classPath, g.d(file, Charset.forName("UTF-8")));
    }
}
