package com.tencent.ntcompose.core;

import com.tencent.ntcompose.core.i;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016R4\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ntcompose/core/ModifierAttribute;", "", "", "c", "()Ljava/lang/Float;", "b", "", "toString", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "attributeMap", "Lcom/tencent/ntcompose/core/i;", "modifier", "<init>", "(Lcom/tencent/ntcompose/core/i;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ModifierAttribute {

    /* renamed from: c, reason: collision with root package name */
    public static final int f339206c = 8;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, Object> attributeMap;

    public ModifierAttribute(i modifier) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        this.attributeMap = new HashMap<>();
        modifier.a(Unit.INSTANCE, new Function2<i.c, Unit, Unit>() { // from class: com.tencent.ntcompose.core.ModifierAttribute.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(i.c cVar, Unit unit) {
                invoke2(cVar, unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(i.c element, Unit unit) {
                Intrinsics.checkNotNullParameter(element, "element");
                Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 1>");
                if (element instanceof k) {
                    k kVar = (k) element;
                    String propKey = kVar.getPropKey();
                    int hashCode = propKey.hashCode();
                    if (hashCode != -1019779949) {
                        if (hashCode != 3530753) {
                            if (hashCode == 1052666732 && propKey.equals("transform")) {
                                ModifierAttribute.this.attributeMap.put("scale", kVar.getPropArg1());
                                ModifierAttribute.this.attributeMap.put("anchor", kVar.getPropArg3());
                                return;
                            }
                        } else if (propKey.equals("size")) {
                            ModifierAttribute.this.attributeMap.put("width", kVar.getPropArg0());
                            ModifierAttribute.this.attributeMap.put("height", kVar.getPropArg1());
                            return;
                        }
                    } else if (propKey.equals("offset")) {
                        ModifierAttribute.this.attributeMap.put("offsetX", kVar.getPropArg0());
                        ModifierAttribute.this.attributeMap.put("offsetY", kVar.getPropArg1());
                        return;
                    }
                    ModifierAttribute.this.attributeMap.put(kVar.getPropKey(), kVar.getPropArg0());
                }
            }
        });
    }

    public final Float b() {
        Object obj = this.attributeMap.get("height");
        if (obj instanceof Float) {
            return (Float) obj;
        }
        return null;
    }

    public final Float c() {
        Object obj = this.attributeMap.get("width");
        if (obj instanceof Float) {
            return (Float) obj;
        }
        return null;
    }

    public String toString() {
        String obj = this.attributeMap.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "attributeMap.toString()");
        return obj;
    }
}
