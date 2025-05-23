package org.jf.dexlib2.writer.util;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import org.jf.dexlib2.base.value.BaseArrayEncodedValue;
import org.jf.dexlib2.base.value.BaseMethodHandleEncodedValue;
import org.jf.dexlib2.base.value.BaseMethodTypeEncodedValue;
import org.jf.dexlib2.iface.reference.CallSiteReference;
import org.jf.dexlib2.iface.reference.MethodHandleReference;
import org.jf.dexlib2.iface.reference.MethodProtoReference;
import org.jf.dexlib2.iface.value.ArrayEncodedValue;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableStringEncodedValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CallSiteUtil {
    public static ArrayEncodedValue getEncodedCallSite(final CallSiteReference callSiteReference) {
        return new BaseArrayEncodedValue() { // from class: org.jf.dexlib2.writer.util.CallSiteUtil.1
            @Override // org.jf.dexlib2.iface.value.ArrayEncodedValue
            @Nonnull
            public List<? extends EncodedValue> getValue() {
                ArrayList h16 = Lists.h();
                h16.add(new BaseMethodHandleEncodedValue() { // from class: org.jf.dexlib2.writer.util.CallSiteUtil.1.1
                    @Override // org.jf.dexlib2.iface.value.MethodHandleEncodedValue
                    @Nonnull
                    public MethodHandleReference getValue() {
                        return CallSiteReference.this.getMethodHandle();
                    }
                });
                h16.add(new ImmutableStringEncodedValue(CallSiteReference.this.getMethodName()));
                h16.add(new BaseMethodTypeEncodedValue() { // from class: org.jf.dexlib2.writer.util.CallSiteUtil.1.2
                    @Override // org.jf.dexlib2.iface.value.MethodTypeEncodedValue
                    @Nonnull
                    public MethodProtoReference getValue() {
                        return CallSiteReference.this.getMethodProto();
                    }
                });
                h16.addAll(CallSiteReference.this.getExtraArguments());
                return h16;
            }
        };
    }
}
