package com.tencent.opentelemetry.api.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.internal.ImmutableKeyValuePairs;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Function;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ArrayBackedAttributes extends ImmutableKeyValuePairs<AttributeKey<?>, Object> implements Attributes {
    static IPatchRedirector $redirector_;
    static final Attributes EMPTY;
    private static final Comparator<AttributeKey<?>> KEY_COMPARATOR_FOR_CONSTRUCTION;

    static {
        Comparator<AttributeKey<?>> comparing;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16278);
        $redirector_ = redirector;
        if (redirector == null || !redirector.hasPatch((short) 5)) {
            comparing = Comparator.comparing(new Function() { // from class: com.tencent.opentelemetry.api.common.b
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((AttributeKey) obj).getKey();
                }
            });
            KEY_COMPARATOR_FOR_CONSTRUCTION = comparing;
            EMPTY = f.a().build();
            return;
        }
        redirector.redirect((short) 5);
    }

    ArrayBackedAttributes(Object[] objArr, Comparator<AttributeKey<?>> comparator) {
        super(objArr, comparator);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) objArr, (Object) comparator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Attributes sortAndFilterToAttributes(Object... objArr) {
        for (int i3 = 0; i3 < objArr.length; i3 += 2) {
            AttributeKey attributeKey = (AttributeKey) objArr[i3];
            if (attributeKey != null && attributeKey.getKey().isEmpty()) {
                objArr[i3] = null;
            }
        }
        return new ArrayBackedAttributes(objArr, KEY_COMPARATOR_FOR_CONSTRUCTION);
    }

    @Override // com.tencent.opentelemetry.api.common.Attributes
    @Nullable
    public <T> T get(AttributeKey<T> attributeKey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, (Object) this, (Object) attributeKey);
        }
        return (T) super.get((ArrayBackedAttributes) attributeKey);
    }

    @Override // com.tencent.opentelemetry.api.common.Attributes
    public AttributesBuilder toBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AttributesBuilder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new ArrayBackedAttributesBuilder(new ArrayList(data()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayBackedAttributes(Object[] objArr) {
        super(objArr);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) objArr);
    }
}
