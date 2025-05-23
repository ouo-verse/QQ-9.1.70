package org.jf.dexlib2.formatter;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import org.jf.dexlib2.iface.reference.CallSiteReference;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodHandleReference;
import org.jf.dexlib2.iface.reference.MethodProtoReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.iface.value.EncodedValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexFormatter {
    public static final DexFormatter INSTANCE = new DexFormatter();

    public String getCallSite(CallSiteReference callSiteReference) {
        StringWriter stringWriter = new StringWriter();
        try {
            getWriter(stringWriter).writeCallSite(callSiteReference);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError("Unexpected IOException");
        }
    }

    public String getEncodedValue(EncodedValue encodedValue) {
        StringWriter stringWriter = new StringWriter();
        try {
            getWriter(stringWriter).writeEncodedValue(encodedValue);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError("Unexpected IOException");
        }
    }

    public String getFieldDescriptor(FieldReference fieldReference) {
        StringWriter stringWriter = new StringWriter();
        try {
            getWriter(stringWriter).writeFieldDescriptor(fieldReference);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError("Unexpected IOException");
        }
    }

    public String getMethodDescriptor(MethodReference methodReference) {
        StringWriter stringWriter = new StringWriter();
        try {
            getWriter(stringWriter).writeMethodDescriptor(methodReference);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError("Unexpected IOException");
        }
    }

    public String getMethodHandle(MethodHandleReference methodHandleReference) {
        StringWriter stringWriter = new StringWriter();
        try {
            getWriter(stringWriter).writeMethodHandle(methodHandleReference);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError("Unexpected IOException");
        }
    }

    public String getMethodProtoDescriptor(MethodProtoReference methodProtoReference) {
        StringWriter stringWriter = new StringWriter();
        try {
            getWriter(stringWriter).writeMethodProtoDescriptor(methodProtoReference);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError("Unexpected IOException");
        }
    }

    public String getQuotedString(CharSequence charSequence) {
        StringWriter stringWriter = new StringWriter();
        try {
            getWriter(stringWriter).writeQuotedString(charSequence);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError("Unexpected IOException");
        }
    }

    public String getReference(Reference reference) {
        StringWriter stringWriter = new StringWriter();
        try {
            getWriter(stringWriter).writeReference(reference);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError("Unexpected IOException");
        }
    }

    public String getShortFieldDescriptor(FieldReference fieldReference) {
        StringWriter stringWriter = new StringWriter();
        try {
            getWriter(stringWriter).writeShortFieldDescriptor(fieldReference);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError("Unexpected IOException");
        }
    }

    public String getShortMethodDescriptor(MethodReference methodReference) {
        StringWriter stringWriter = new StringWriter();
        try {
            getWriter(stringWriter).writeShortMethodDescriptor(methodReference);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError("Unexpected IOException");
        }
    }

    public String getType(CharSequence charSequence) {
        StringWriter stringWriter = new StringWriter();
        try {
            getWriter(stringWriter).writeType(charSequence);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError("Unexpected IOException");
        }
    }

    public DexFormattedWriter getWriter(Writer writer) {
        return new DexFormattedWriter(writer);
    }
}
