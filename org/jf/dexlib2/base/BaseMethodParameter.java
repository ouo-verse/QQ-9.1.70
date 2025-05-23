package org.jf.dexlib2.base;

import java.util.Iterator;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.reference.BaseTypeReference;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.AnnotationElement;
import org.jf.dexlib2.iface.MethodParameter;
import org.jf.dexlib2.iface.value.ArrayEncodedValue;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.iface.value.StringEncodedValue;

/* loaded from: classes29.dex */
public abstract class BaseMethodParameter extends BaseTypeReference implements MethodParameter {
    @Override // org.jf.dexlib2.iface.MethodParameter, org.jf.dexlib2.iface.debug.LocalInfo
    @Nullable
    public String getSignature() {
        Annotation annotation;
        ArrayEncodedValue arrayEncodedValue;
        Iterator<? extends Annotation> it = getAnnotations().iterator();
        while (true) {
            if (it.hasNext()) {
                annotation = it.next();
                if (annotation.getType().equals("Ldalvik/annotation/Signature;")) {
                    break;
                }
            } else {
                annotation = null;
                break;
            }
        }
        if (annotation == null) {
            return null;
        }
        Iterator<? extends AnnotationElement> it5 = annotation.getElements().iterator();
        while (true) {
            if (it5.hasNext()) {
                AnnotationElement next = it5.next();
                if (next.getName().equals("value")) {
                    EncodedValue value = next.getValue();
                    if (value.getValueType() != 28) {
                        return null;
                    }
                    arrayEncodedValue = (ArrayEncodedValue) value;
                }
            } else {
                arrayEncodedValue = null;
                break;
            }
        }
        if (arrayEncodedValue == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        for (EncodedValue encodedValue : arrayEncodedValue.getValue()) {
            if (encodedValue.getValueType() != 23) {
                return null;
            }
            sb5.append(((StringEncodedValue) encodedValue).getValue());
        }
        return sb5.toString();
    }
}
