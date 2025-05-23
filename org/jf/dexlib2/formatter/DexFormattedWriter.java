package org.jf.dexlib2.formatter;

import com.tencent.mobileqq.tianshu.ui.RedTouch;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import org.jf.dexlib2.MethodHandleType;
import org.jf.dexlib2.iface.AnnotationElement;
import org.jf.dexlib2.iface.reference.CallSiteReference;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodHandleReference;
import org.jf.dexlib2.iface.reference.MethodProtoReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.iface.reference.StringReference;
import org.jf.dexlib2.iface.reference.TypeReference;
import org.jf.dexlib2.iface.value.AnnotationEncodedValue;
import org.jf.dexlib2.iface.value.ArrayEncodedValue;
import org.jf.dexlib2.iface.value.BooleanEncodedValue;
import org.jf.dexlib2.iface.value.ByteEncodedValue;
import org.jf.dexlib2.iface.value.CharEncodedValue;
import org.jf.dexlib2.iface.value.DoubleEncodedValue;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.iface.value.EnumEncodedValue;
import org.jf.dexlib2.iface.value.FieldEncodedValue;
import org.jf.dexlib2.iface.value.FloatEncodedValue;
import org.jf.dexlib2.iface.value.IntEncodedValue;
import org.jf.dexlib2.iface.value.LongEncodedValue;
import org.jf.dexlib2.iface.value.MethodEncodedValue;
import org.jf.dexlib2.iface.value.MethodHandleEncodedValue;
import org.jf.dexlib2.iface.value.MethodTypeEncodedValue;
import org.jf.dexlib2.iface.value.ShortEncodedValue;
import org.jf.dexlib2.iface.value.StringEncodedValue;
import org.jf.dexlib2.iface.value.TypeEncodedValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexFormattedWriter extends Writer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected final Writer writer;

    public DexFormattedWriter(Writer writer) {
        this.writer = writer;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.writer.close();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        this.writer.flush();
    }

    @Override // java.io.Writer
    public void write(int i3) throws IOException {
        this.writer.write(i3);
    }

    protected void writeAnnotation(AnnotationEncodedValue annotationEncodedValue) throws IOException {
        this.writer.write("Annotation[");
        writeType(annotationEncodedValue.getType());
        for (AnnotationElement annotationElement : annotationEncodedValue.getElements()) {
            this.writer.write(", ");
            writeSimpleName(annotationElement.getName());
            this.writer.write(61);
            writeEncodedValue(annotationElement.getValue());
        }
        this.writer.write(93);
    }

    protected void writeArray(ArrayEncodedValue arrayEncodedValue) throws IOException {
        this.writer.write("Array[");
        boolean z16 = true;
        for (EncodedValue encodedValue : arrayEncodedValue.getValue()) {
            if (z16) {
                z16 = false;
            } else {
                this.writer.write(", ");
            }
            writeEncodedValue(encodedValue);
        }
        this.writer.write(93);
    }

    public void writeCallSite(CallSiteReference callSiteReference) throws IOException {
        writeSimpleName(callSiteReference.getName());
        this.writer.write(40);
        writeQuotedString(callSiteReference.getMethodName());
        this.writer.write(", ");
        writeMethodProtoDescriptor(callSiteReference.getMethodProto());
        for (EncodedValue encodedValue : callSiteReference.getExtraArguments()) {
            this.writer.write(", ");
            writeEncodedValue(encodedValue);
        }
        this.writer.write(")@");
        if (callSiteReference.getMethodHandle().getMethodHandleType() == 4) {
            writeMethodDescriptor((MethodReference) callSiteReference.getMethodHandle().getMemberReference());
            return;
        }
        throw new IllegalArgumentException("The linker method handle for a call site must be of type invoke-static");
    }

    protected void writeClass(CharSequence charSequence) throws IOException {
        this.writer.write(charSequence.charAt(0));
        int i3 = 1;
        int i16 = 1;
        while (true) {
            if (i3 >= charSequence.length()) {
                break;
            }
            char charAt = charSequence.charAt(i3);
            if (charAt == '/') {
                if (i3 != i16) {
                    writeSimpleName(charSequence.subSequence(i16, i3));
                    this.writer.write(charSequence.charAt(i3));
                    i16 = i3 + 1;
                } else {
                    throw new IllegalArgumentException(String.format("Invalid type string: %s", charSequence));
                }
            } else if (charAt == ';') {
                if (i3 != i16) {
                    writeSimpleName(charSequence.subSequence(i16, i3));
                    this.writer.write(charSequence.charAt(i3));
                } else {
                    throw new IllegalArgumentException(String.format("Invalid type string: %s", charSequence));
                }
            }
            i3++;
        }
        if (i3 == charSequence.length() - 1 && charSequence.charAt(i3) == ';') {
        } else {
            throw new IllegalArgumentException(String.format("Invalid type string: %s", charSequence));
        }
    }

    public void writeEncodedValue(EncodedValue encodedValue) throws IOException {
        int valueType = encodedValue.getValueType();
        if (valueType != 0) {
            if (valueType != 6) {
                if (valueType != 2) {
                    if (valueType != 3) {
                        if (valueType != 4) {
                            if (valueType != 16) {
                                if (valueType != 17) {
                                    switch (valueType) {
                                        case 21:
                                            writeMethodProtoDescriptor(((MethodTypeEncodedValue) encodedValue).getValue());
                                            return;
                                        case 22:
                                            writeMethodHandle(((MethodHandleEncodedValue) encodedValue).getValue());
                                            return;
                                        case 23:
                                            writeQuotedString(((StringEncodedValue) encodedValue).getValue());
                                            return;
                                        case 24:
                                            writeType(((TypeEncodedValue) encodedValue).getValue());
                                            return;
                                        case 25:
                                            writeFieldDescriptor(((FieldEncodedValue) encodedValue).getValue());
                                            return;
                                        case 26:
                                            writeMethodDescriptor(((MethodEncodedValue) encodedValue).getValue());
                                            return;
                                        case 27:
                                            writeFieldDescriptor(((EnumEncodedValue) encodedValue).getValue());
                                            return;
                                        case 28:
                                            writeArray((ArrayEncodedValue) encodedValue);
                                            return;
                                        case 29:
                                            writeAnnotation((AnnotationEncodedValue) encodedValue);
                                            return;
                                        case 30:
                                            this.writer.write("null");
                                            return;
                                        case 31:
                                            this.writer.write(Boolean.toString(((BooleanEncodedValue) encodedValue).getValue()));
                                            return;
                                        default:
                                            throw new IllegalArgumentException("Unknown encoded value type");
                                    }
                                }
                                this.writer.write(Double.toString(((DoubleEncodedValue) encodedValue).getValue()));
                                return;
                            }
                            this.writer.write(Float.toString(((FloatEncodedValue) encodedValue).getValue()));
                            return;
                        }
                        this.writer.write(String.format("0x%x", Integer.valueOf(((IntEncodedValue) encodedValue).getValue())));
                        return;
                    }
                    this.writer.write(String.format("0x%x", Integer.valueOf(((CharEncodedValue) encodedValue).getValue())));
                    return;
                }
                this.writer.write(String.format("0x%x", Short.valueOf(((ShortEncodedValue) encodedValue).getValue())));
                return;
            }
            this.writer.write(String.format("0x%x", Long.valueOf(((LongEncodedValue) encodedValue).getValue())));
            return;
        }
        this.writer.write(String.format("0x%x", Byte.valueOf(((ByteEncodedValue) encodedValue).getValue())));
    }

    public void writeFieldDescriptor(FieldReference fieldReference) throws IOException {
        writeType(fieldReference.getDefiningClass());
        this.writer.write("->");
        writeSimpleName(fieldReference.getName());
        this.writer.write(58);
        writeType(fieldReference.getType());
    }

    public void writeMethodDescriptor(MethodReference methodReference) throws IOException {
        writeType(methodReference.getDefiningClass());
        this.writer.write("->");
        writeSimpleName(methodReference.getName());
        this.writer.write(40);
        Iterator<? extends CharSequence> it = methodReference.getParameterTypes().iterator();
        while (it.hasNext()) {
            writeType(it.next());
        }
        this.writer.write(41);
        writeType(methodReference.getReturnType());
    }

    public void writeMethodHandle(MethodHandleReference methodHandleReference) throws IOException {
        this.writer.write(MethodHandleType.toString(methodHandleReference.getMethodHandleType()));
        this.writer.write(64);
        Reference memberReference = methodHandleReference.getMemberReference();
        if (memberReference instanceof MethodReference) {
            writeMethodDescriptor((MethodReference) memberReference);
        } else {
            writeFieldDescriptor((FieldReference) memberReference);
        }
    }

    public void writeMethodProtoDescriptor(MethodProtoReference methodProtoReference) throws IOException {
        this.writer.write(40);
        Iterator<? extends CharSequence> it = methodProtoReference.getParameterTypes().iterator();
        while (it.hasNext()) {
            writeType(it.next());
        }
        this.writer.write(41);
        writeType(methodProtoReference.getReturnType());
    }

    public void writeQuotedString(CharSequence charSequence) throws IOException {
        this.writer.write(34);
        String charSequence2 = charSequence.toString();
        for (int i3 = 0; i3 < charSequence2.length(); i3++) {
            char charAt = charSequence2.charAt(i3);
            if (charAt >= ' ' && charAt < '\u007f') {
                if (charAt == '\'' || charAt == '\"' || charAt == '\\') {
                    this.writer.write(92);
                }
                this.writer.write(charAt);
            } else {
                if (charAt <= '\u007f') {
                    if (charAt != '\t') {
                        if (charAt != '\n') {
                            if (charAt == '\r') {
                                this.writer.write("\\r");
                            }
                        } else {
                            this.writer.write(RedTouch.NEWLINE_CHAR);
                        }
                    } else {
                        this.writer.write("\\t");
                    }
                }
                this.writer.write("\\u");
                this.writer.write(Character.forDigit(charAt >> '\f', 16));
                this.writer.write(Character.forDigit((charAt >> '\b') & 15, 16));
                this.writer.write(Character.forDigit((charAt >> 4) & 15, 16));
                this.writer.write(Character.forDigit(charAt & 15, 16));
            }
        }
        this.writer.write(34);
    }

    public void writeReference(Reference reference) throws IOException {
        if (reference instanceof StringReference) {
            writeQuotedString((StringReference) reference);
            return;
        }
        if (reference instanceof TypeReference) {
            writeType((TypeReference) reference);
            return;
        }
        if (reference instanceof FieldReference) {
            writeFieldDescriptor((FieldReference) reference);
            return;
        }
        if (reference instanceof MethodReference) {
            writeMethodDescriptor((MethodReference) reference);
            return;
        }
        if (reference instanceof MethodProtoReference) {
            writeMethodProtoDescriptor((MethodProtoReference) reference);
        } else if (reference instanceof MethodHandleReference) {
            writeMethodHandle((MethodHandleReference) reference);
        } else {
            if (reference instanceof CallSiteReference) {
                writeCallSite((CallSiteReference) reference);
                return;
            }
            throw new IllegalArgumentException(String.format("Not a known reference type: %s", reference.getClass()));
        }
    }

    public void writeShortFieldDescriptor(FieldReference fieldReference) throws IOException {
        writeSimpleName(fieldReference.getName());
        this.writer.write(58);
        writeType(fieldReference.getType());
    }

    public void writeShortMethodDescriptor(MethodReference methodReference) throws IOException {
        writeSimpleName(methodReference.getName());
        this.writer.write(40);
        Iterator<? extends CharSequence> it = methodReference.getParameterTypes().iterator();
        while (it.hasNext()) {
            writeType(it.next());
        }
        this.writer.write(41);
        writeType(methodReference.getReturnType());
    }

    protected void writeSimpleName(CharSequence charSequence) throws IOException {
        this.writer.append(charSequence);
    }

    public void writeType(CharSequence charSequence) throws IOException {
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            char charAt = charSequence.charAt(i3);
            if (charAt == 'L') {
                writeClass(charSequence.subSequence(i3, charSequence.length()));
                return;
            }
            if (charAt == '[') {
                this.writer.write(charAt);
            } else {
                if (charAt != 'Z' && charAt != 'B' && charAt != 'S' && charAt != 'C' && charAt != 'I' && charAt != 'J' && charAt != 'F' && charAt != 'D' && charAt != 'V') {
                    throw new IllegalArgumentException(String.format("Invalid type string: %s", charSequence));
                }
                this.writer.write(charAt);
                if (i3 == charSequence.length() - 1) {
                    return;
                } else {
                    throw new IllegalArgumentException(String.format("Invalid type string: %s", charSequence));
                }
            }
        }
        throw new IllegalArgumentException(String.format("Invalid type string: %s", charSequence));
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        this.writer.write(cArr);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i16) throws IOException {
        this.writer.write(cArr, i3, i16);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) throws IOException {
        return this.writer.append(charSequence);
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        this.writer.write(str);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i3, int i16) throws IOException {
        return this.writer.append(charSequence, i3, i16);
    }

    @Override // java.io.Writer
    public void write(String str, int i3, int i16) throws IOException {
        this.writer.write(str, i3, i16);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c16) throws IOException {
        return this.writer.append(c16);
    }
}
