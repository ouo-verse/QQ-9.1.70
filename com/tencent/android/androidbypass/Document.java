package com.tencent.android.androidbypass;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0003j\b\u0012\u0004\u0012\u00020\b`\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/android/androidbypass/Document;", "", "jniElement", "Ljava/util/ArrayList;", "Lcom/tencent/bypass/nativeinterface/Element;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "Lcom/tencent/android/androidbypass/Element;", "getElements", "()Ljava/util/ArrayList;", "getElement", com.tencent.luggage.wxa.c8.c.G, "", "getElementCount", "toString", "", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class Document {
    static IPatchRedirector $redirector_;

    @NotNull
    private final ArrayList<Element> elements;

    public Document() {
        this(null, 1, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this);
    }

    @NotNull
    public final Element getElement(int pos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Element) iPatchRedirector.redirect((short) 3, (Object) this, pos);
        }
        Element element = this.elements.get(pos);
        Intrinsics.checkNotNullExpressionValue(element, "elements[pos]");
        return element;
    }

    public final int getElementCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.elements.size();
    }

    @NotNull
    public final ArrayList<Element> getElements() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (ArrayList) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.elements;
    }

    @NotNull
    public String toString() {
        String trimIndent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        trimIndent = StringsKt__IndentKt.trimIndent("\n            Document {\n                count: " + getElementCount() + ",\n                children: " + this.elements + ",\n            }\n        ");
        return trimIndent;
    }

    public Document(@NotNull ArrayList<com.tencent.bypass.nativeinterface.Element> jniElement) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(jniElement, "jniElement");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) jniElement);
            return;
        }
        ArrayList<Element> arrayList = new ArrayList<>();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(jniElement, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = jniElement.iterator();
        while (it.hasNext()) {
            arrayList2.add(new Element((com.tencent.bypass.nativeinterface.Element) it.next(), null));
        }
        arrayList.addAll(arrayList2);
        Unit unit = Unit.INSTANCE;
        this.elements = arrayList;
    }

    public /* synthetic */ Document(ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : arrayList);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, this, arrayList, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
