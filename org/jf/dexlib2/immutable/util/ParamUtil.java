package org.jf.dexlib2.immutable.util;

import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import javax.annotation.Nonnull;
import org.jf.dexlib2.immutable.ImmutableAnnotation;
import org.jf.dexlib2.immutable.ImmutableMethodParameter;

/* loaded from: classes29.dex */
public class ParamUtil {
    /* JADX INFO: Access modifiers changed from: private */
    public static int findTypeEnd(@Nonnull String str, int i3) {
        char charAt = str.charAt(i3);
        if (charAt != 'F') {
            if (charAt == 'L') {
                while (true) {
                    int i16 = i3 + 1;
                    if (str.charAt(i3) != ';') {
                        i3 = i16;
                    } else {
                        return i16;
                    }
                }
            } else if (charAt != 'S' && charAt != 'I' && charAt != 'J' && charAt != 'Z') {
                if (charAt != '[') {
                    switch (charAt) {
                        case 'B':
                        case 'C':
                        case 'D':
                            break;
                        default:
                            throw new IllegalArgumentException(String.format("Param string \"%s\" contains invalid type prefix: %s", str, Character.toString(charAt)));
                    }
                } else {
                    while (true) {
                        int i17 = i3 + 1;
                        if (str.charAt(i3) != '[') {
                            i3 = i17;
                        } else {
                            return findTypeEnd(str, i17);
                        }
                    }
                }
            }
        }
        return i3 + 1;
    }

    @Nonnull
    public static Iterable<ImmutableMethodParameter> parseParamString(@Nonnull final String str) {
        return new Iterable<ImmutableMethodParameter>() { // from class: org.jf.dexlib2.immutable.util.ParamUtil.1
            @Override // java.lang.Iterable
            public Iterator<ImmutableMethodParameter> iterator() {
                return new Iterator<ImmutableMethodParameter>() { // from class: org.jf.dexlib2.immutable.util.ParamUtil.1.1
                    private int index = 0;

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        if (this.index < str.length()) {
                            return true;
                        }
                        return false;
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                    @Override // java.util.Iterator
                    public ImmutableMethodParameter next() {
                        int findTypeEnd = ParamUtil.findTypeEnd(str, this.index);
                        String substring = str.substring(this.index, findTypeEnd);
                        this.index = findTypeEnd;
                        return new ImmutableMethodParameter(substring, (ImmutableSet<? extends ImmutableAnnotation>) null, (String) null);
                    }
                };
            }
        };
    }
}
