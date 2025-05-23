package com.tencent.android.androidbypass.viewgroup;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.android.androidbypass.Bypass;
import com.tencent.android.androidbypass.BypassSoEngine;
import com.tencent.android.androidbypass.Document;
import com.tencent.android.androidbypass.Element;
import com.tencent.android.androidbypass.enhance.i;
import com.tencent.android.androidbypass.parser.a;
import com.tencent.android.androidbypass.parser.d;
import com.tencent.android.androidbypass.richui.viewdata.k;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.bypass.nativeinterface.Attribute;
import com.tencent.bypass.nativeinterface.CustomElement;
import com.tencent.bypass.nativeinterface.CustomReplaceElement;
import com.tencent.bypass.nativeinterface.CustomStyleElement;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010=\u001a\u000209\u00a2\u0006\u0004\b>\u0010?J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J \u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\tj\b\u0012\u0004\u0012\u00020\u0003`\n2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001e\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00022\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\tj\b\u0012\u0004\u0012\u00020\u0003`\nH\u0002J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\"\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0014H\u0002J\"\u0010\"\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010!\u001a\u00020 H\u0002JH\u0010+\u001a\u00020*2\u0006\u0010\u0019\u001a\u00020\u00182\"\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\f0#j\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\f`$2\b\b\u0002\u0010'\u001a\u00020&2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(J\u001e\u00101\u001a\u0002002\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.JD\u00108\u001a\u0012\u0012\u0004\u0012\u0002070\tj\b\u0012\u0004\u0012\u000207`\n2\u0006\u00103\u001a\u0002022\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.2\u0006\u00106\u001a\u000205R\u0017\u0010=\u001a\u0002098\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010:\u001a\u0004\b;\u0010<\u00a8\u0006@"}, d2 = {"Lcom/tencent/android/androidbypass/viewgroup/a;", "", "", "Lcom/tencent/android/androidbypass/Element;", "elementList", "Lcom/tencent/android/androidbypass/viewgroup/b;", "a", "Lcom/tencent/android/androidbypass/Document;", "document", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "k", "", "isEnd", "", "e", "Lcom/tencent/android/androidbypass/viewgroup/c;", "i", DTConstants.TAG.ELEMENT, "c", "", "level", "b", "d", "", "markdown", "enableParseCodeBlock", "parseCodeBlockLine", "j", "Landroid/util/DisplayMetrics;", "displayMetrics", "unit", "", "size", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "switchMap", "Lorg/json/JSONObject;", "dataJSONObject", "Lcom/tencent/android/androidbypass/richui/b;", "processInterface", "Lcom/tencent/android/androidbypass/viewgroup/e;", "f", "Lcom/tencent/android/androidbypass/parser/d$b;", "option", "Lcom/tencent/android/androidbypass/parser/a$b;", "parseOption", "", h.F, "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "elementGroupList", "Lcom/tencent/android/androidbypass/viewgroup/d;", "markdownRender", "Lcom/tencent/android/androidbypass/viewgroup/render/a;", "l", "Lcom/tencent/android/androidbypass/Bypass;", "Lcom/tencent/android/androidbypass/Bypass;", "getBypass", "()Lcom/tencent/android/androidbypass/Bypass;", "bypass", "<init>", "(Lcom/tencent/android/androidbypass/Bypass;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: a, reason: from kotlin metadata */
    @NotNull
    private final Bypass bypass;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/android/androidbypass/viewgroup/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.viewgroup.a$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19334);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull Bypass bypass) {
        Intrinsics.checkNotNullParameter(bypass, "bypass");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bypass);
        } else {
            this.bypass = bypass;
        }
    }

    private final List<b> a(List<Element> elementList) {
        int size = elementList.size();
        ArrayList arrayList = new ArrayList();
        b bVar = new b(null, 0, 3, null);
        arrayList.add(bVar);
        for (int i3 = 0; i3 < size; i3++) {
            Element element = elementList.get(i3);
            if (com.tencent.android.androidbypass.c.c(element)) {
                if (!bVar.a().isEmpty()) {
                    bVar = new b(null, 0, 3, null);
                    arrayList.add(bVar);
                }
                bVar.a().add(element);
                bVar.d(2);
                bVar = new b(null, 0, 3, null);
                arrayList.add(bVar);
            } else if (com.tencent.android.androidbypass.c.a(element)) {
                if (!bVar.a().isEmpty()) {
                    bVar = new b(null, 0, 3, null);
                    arrayList.add(bVar);
                }
                bVar.a().add(element);
                bVar.d(3);
                bVar = new b(null, 0, 3, null);
                arrayList.add(bVar);
            } else if (com.tencent.android.androidbypass.c.b(element)) {
                if (bVar.a().isEmpty()) {
                    arrayList.remove(bVar);
                }
                f fVar = new f(null, 0, 3, null);
                arrayList.add(fVar);
                fVar.a().add(element);
                fVar.d(4);
                bVar = new b(null, 0, 3, null);
                arrayList.add(bVar);
            } else {
                bVar.a().add(element);
            }
        }
        return arrayList;
    }

    private final List<Element> b(Element r122, int level) {
        ArrayList arrayList = new ArrayList();
        Element copyWithoutChild = r122.copyWithoutChild();
        Iterator<Element> it = r122.children.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "element.children.iterator()");
        Element element = copyWithoutChild;
        boolean z16 = false;
        while (it.hasNext()) {
            Element next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            Element element2 = next;
            element.children.add(element2);
            element2.parent = copyWithoutChild;
            if (!z16) {
                arrayList.add(element);
                z16 = true;
            }
            Iterator<Element> it5 = element2.children.iterator();
            Intrinsics.checkNotNullExpressionValue(it5, "child.children.iterator()");
            ArrayList arrayList2 = new ArrayList();
            while (it5.hasNext()) {
                Element next2 = it5.next();
                Intrinsics.checkNotNullExpressionValue(next2, "childIterator.next()");
                Element element3 = next2;
                if (!com.tencent.android.androidbypass.c.a(element3) && !com.tencent.android.androidbypass.c.b(element3)) {
                    if (element3.type == Element.Type.LIST) {
                        arrayList2.addAll(d(element3));
                    } else {
                        arrayList2.add(element3);
                    }
                } else {
                    arrayList.add(element3);
                    it5.remove();
                    element = element.copyWithoutChild();
                    z16 = false;
                }
            }
            element2.children.clear();
            element2.children.addAll(arrayList2);
        }
        if (level > 0 && arrayList.size() == 1) {
            Object obj = arrayList.get(0);
            Intrinsics.checkNotNullExpressionValue(obj, "list.get(0)");
            arrayList.clear();
            arrayList.addAll(b((Element) obj, level - 1));
        }
        return arrayList;
    }

    private final List<Element> c(Element r75) {
        ArrayList arrayListOf;
        ArrayList arrayListOf2;
        if (r75.type != Element.Type.PARAGRAPH) {
            arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(r75);
            return arrayListOf2;
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(r75);
        ListIterator<Element> listIterator = r75.children.listIterator(r75.children.size());
        Intrinsics.checkNotNullExpressionValue(listIterator, "element.children.listIterator(size)");
        boolean z16 = false;
        while (listIterator.hasPrevious()) {
            Element previous = listIterator.previous();
            Intrinsics.checkNotNullExpressionValue(previous, "iterator.previous()");
            Element element = previous;
            if (com.tencent.android.androidbypass.c.c(element) || com.tencent.android.androidbypass.c.a(element) || com.tencent.android.androidbypass.c.b(element)) {
                z16 = true;
            }
            if (z16) {
                arrayListOf.add(0, element);
                listIterator.remove();
            }
        }
        return arrayListOf;
    }

    private final List<Element> d(Element r65) {
        ArrayList arrayList = new ArrayList();
        Iterator<Element> it = r65.children.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "element.children.iterator()");
        while (it.hasNext()) {
            Element next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            Iterator<Element> it5 = next.children.iterator();
            Intrinsics.checkNotNullExpressionValue(it5, "child.children.iterator()");
            while (it5.hasNext()) {
                Element next2 = it5.next();
                Intrinsics.checkNotNullExpressionValue(next2, "childIterator.next()");
                Element element = next2;
                if (com.tencent.android.androidbypass.c.a(element) || com.tencent.android.androidbypass.c.b(element)) {
                    arrayList.add(element);
                    it5.remove();
                }
            }
        }
        arrayList.add(0, r65);
        return arrayList;
    }

    private final void e(List<Element> elementList, boolean isEnd) {
        boolean z16;
        int size = elementList.size();
        int i3 = 0;
        for (Object obj : elementList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Element element = (Element) obj;
            element.getIndexInParentInfo().e(i3);
            com.tencent.android.androidbypass.f indexInParentInfo = element.getIndexInParentInfo();
            if (isEnd && i3 == size - 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            indexInParentInfo.d(z16);
            element.getIndexInParentInfo().f(size);
            if (!element.children.isEmpty()) {
                e(element.children, element.getIndexInParentInfo().c());
            }
            i3 = i16;
        }
    }

    public static /* synthetic */ e g(a aVar, String str, HashMap hashMap, JSONObject jSONObject, com.tencent.android.androidbypass.richui.b bVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            jSONObject = new JSONObject();
        }
        if ((i3 & 8) != 0) {
            bVar = null;
        }
        return aVar.f(str, hashMap, jSONObject, bVar);
    }

    private final List<c> i(ArrayList<Element> elementList) {
        boolean z16;
        CustomElement customElement;
        CustomElement customElement2;
        boolean z17;
        String str;
        boolean equals$default;
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<Element> it = elementList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "elementList.iterator()");
            ArrayList arrayList2 = new ArrayList();
            boolean z18 = false;
            boolean z19 = false;
            boolean z26 = false;
            boolean z27 = false;
            Element element = null;
            c cVar = null;
            while (it.hasNext()) {
                Element next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                Element element2 = next;
                if (z19) {
                    if (element2.type == Element.Type.TEXT && element2.text.equals("\n")) {
                        it.remove();
                    }
                    z16 = z18;
                } else {
                    z16 = z19;
                }
                if (element2.type == Element.Type.CUSTOM_SYNTAX) {
                    Attribute attribute = element2.getAttributes().get(Element.CUSTOM_ELEMENT);
                    if (attribute != null && (customElement = attribute.getCustomElement()) != null) {
                        Intrinsics.checkNotNullExpressionValue(customElement, "element.attributes.get(\"\u2026customElement ?: continue");
                        if (customElement.getElementType() == 1) {
                            CustomStyleElement styleElement = customElement.getStyleElement();
                            Intrinsics.checkNotNullExpressionValue(styleElement, "customElement.styleElement");
                            if (styleElement.getState() == 1) {
                                CustomStyleElement styleElement2 = customElement.getStyleElement();
                                Intrinsics.checkNotNullExpressionValue(styleElement2, "customElement.styleElement");
                                String nodeType = styleElement2.getNodeType();
                                Intrinsics.checkNotNullExpressionValue(nodeType, "customElement.styleElement.nodeType");
                                CustomStyleElement styleElement3 = customElement.getStyleElement();
                                Intrinsics.checkNotNullExpressionValue(styleElement3, "customElement.styleElement");
                                String nodeId = styleElement3.getNodeId();
                                Intrinsics.checkNotNullExpressionValue(nodeId, "customElement.styleElement.nodeId");
                                it.remove();
                                if (element != null) {
                                    str = element.text;
                                } else {
                                    str = null;
                                }
                                equals$default = StringsKt__StringsJVMKt.equals$default(str, "\n", z18, 2, null);
                                if (equals$default && element != null) {
                                    element.setIgnore(true);
                                }
                                CustomStyleElement styleElement4 = customElement.getStyleElement();
                                Intrinsics.checkNotNullExpressionValue(styleElement4, "customElement.styleElement");
                                HashMap<String, String> attrMap = styleElement4.getAttrMap();
                                Intrinsics.checkNotNullExpressionValue(attrMap, "customElement.styleElement.attrMap");
                                customElement2 = customElement;
                                c cVar2 = new c(nodeType, nodeId, attrMap, arrayList2, false, 16, null);
                                arrayList.add(cVar2);
                                cVar = cVar2;
                                z26 = true;
                                z27 = false;
                            } else {
                                customElement2 = customElement;
                            }
                            if (z26) {
                                CustomStyleElement styleElement5 = customElement2.getStyleElement();
                                Intrinsics.checkNotNullExpressionValue(styleElement5, "customElement.styleElement");
                                if (styleElement5.getState() == 2) {
                                    it.remove();
                                    if (cVar != null) {
                                        z17 = true;
                                        cVar.f(true);
                                    } else {
                                        z17 = true;
                                    }
                                    arrayList2 = new ArrayList();
                                    z19 = z17;
                                    z27 = z19;
                                    element = element2;
                                    z18 = false;
                                }
                            }
                        } else if (customElement.getElementType() == 2) {
                            if (z26) {
                                arrayList2.add(customElement.getLink());
                            } else {
                                com.tencent.android.androidbypass.config.a.f72049a.i("BypassV2", "[preProcess]: not have startNode");
                            }
                            it.remove();
                        }
                    } else {
                        z19 = z16;
                        z18 = false;
                    }
                } else if (z26 && !z27) {
                    it.remove();
                } else if (true ^ element2.children.isEmpty()) {
                    try {
                        arrayList.addAll(i(element2.children));
                        z19 = z16;
                        element = element2;
                        z18 = false;
                    } catch (Exception e16) {
                        e = e16;
                        com.tencent.android.androidbypass.config.a.f72049a.i("BypassV2", "[preProcessElement]: " + e);
                        com.tencent.android.androidbypass.config.a.f72049a.i("BypassV2", "[preProcessElement]: customElementList size is " + arrayList.size());
                        return arrayList;
                    }
                }
                z19 = z16;
                element = element2;
                z18 = false;
            }
        } catch (Exception e17) {
            e = e17;
        }
        com.tencent.android.androidbypass.config.a.f72049a.i("BypassV2", "[preProcessElement]: customElementList size is " + arrayList.size());
        return arrayList;
    }

    private final Document j(String markdown, boolean enableParseCodeBlock, int parseCodeBlockLine) {
        com.tencent.android.androidbypass.d dVar = com.tencent.android.androidbypass.b.f71942a;
        dVar.c();
        com.tencent.bypass.nativeinterface.Document processMarkdownV2 = BypassSoEngine.INSTANCE.processMarkdownV2(markdown, enableParseCodeBlock, parseCodeBlockLine);
        dVar.b(com.tencent.android.androidbypass.b.g(com.tencent.android.androidbypass.b.a("markdown_length", String.valueOf(markdown.length())), com.tencent.android.androidbypass.b.a("parse_code", String.valueOf(enableParseCodeBlock)), com.tencent.android.androidbypass.b.a("parse_code_line", String.valueOf(parseCodeBlockLine))));
        if (processMarkdownV2 == null) {
            com.tencent.android.androidbypass.config.a.f72049a.e("BypassV2", "processMarkdown fail JNIDocument = null ");
            return null;
        }
        ArrayList<com.tencent.bypass.nativeinterface.Element> elements = processMarkdownV2.getElements();
        Intrinsics.checkNotNullExpressionValue(elements, "jniDoc.elements");
        return new Document(elements);
    }

    private final ArrayList<Element> k(Document document) {
        ArrayList<Element> arrayList = new ArrayList<>();
        for (Element element : document.getElements()) {
            Element.Type type = element.type;
            if (type == Element.Type.PARAGRAPH) {
                arrayList.addAll(c(element));
            } else if (type == Element.Type.LIST) {
                arrayList.addAll(b(element, 1));
            } else {
                arrayList.add(element);
            }
        }
        return arrayList;
    }

    private final int m(DisplayMetrics displayMetrics, int i3, float f16) {
        if (displayMetrics != null) {
            return (int) TypedValue.applyDimension(i3, f16, displayMetrics);
        }
        return 0;
    }

    @NotNull
    public final e f(@NotNull String markdown, @NotNull HashMap<String, Boolean> switchMap, @NotNull JSONObject dataJSONObject, @Nullable com.tencent.android.androidbypass.richui.b processInterface) {
        List emptyList;
        List emptyList2;
        String b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (e) iPatchRedirector.redirect((short) 1, this, markdown, switchMap, dataJSONObject, processInterface);
        }
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        Intrinsics.checkNotNullParameter(switchMap, "switchMap");
        Intrinsics.checkNotNullParameter(dataJSONObject, "dataJSONObject");
        com.tencent.android.androidbypass.parser.b a16 = com.tencent.android.androidbypass.parser.c.a(markdown);
        if (a16 != null && (b16 = a16.b()) != null) {
            markdown = b16;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Document j3 = j(markdown, true, 20);
        com.tencent.android.androidbypass.config.a.f72049a.d("BypassV2", "markdownToSpannable processMarkdown time:" + (System.currentTimeMillis() - currentTimeMillis));
        if (j3 == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return new e(emptyList, emptyList2);
        }
        List<c> i3 = i(j3.getElements());
        e(j3.getElements(), true);
        List<b> a17 = a(k(j3));
        for (b bVar : a17) {
            if (bVar instanceof f) {
                f fVar = (f) bVar;
                fVar.f(dataJSONObject);
                fVar.g(processInterface);
            }
            bVar.c();
        }
        return new e(a17, i3);
    }

    @NotNull
    public final CharSequence h(@NotNull Element element, @NotNull d.b option, @NotNull a.b parseOption) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CharSequence) iPatchRedirector.redirect((short) 2, this, element, option, parseOption);
        }
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(parseOption, "parseOption");
        CharSequence recurseElement = this.bypass.recurseElement(element, element.getIndexInParentInfo().a(), element.getIndexInParentInfo().b(), option.e(), null, option.i().b(), Boolean.valueOf(element.getIndexInParentInfo().c()), parseOption, null);
        Intrinsics.checkNotNullExpressionValue(recurseElement, "bypass.recurseElement(el\u2026Option,\n            null)");
        return recurseElement;
    }

    @NotNull
    public final ArrayList<com.tencent.android.androidbypass.viewgroup.render.a> l(@NotNull ViewGroup r252, @NotNull List<? extends b> elementGroupList, @NotNull d.b option, @NotNull a.b parseOption, @NotNull d markdownRender) {
        ArrayList<com.tencent.android.androidbypass.viewgroup.render.a> arrayList;
        Context context;
        int i3;
        char c16;
        boolean z16;
        boolean z17;
        int i16;
        f fVar;
        k e16;
        Attribute attribute;
        CustomElement customElement;
        CustomReplaceElement it;
        ViewGroup container = r252;
        IPatchRedirector iPatchRedirector = $redirector_;
        char c17 = 4;
        int i17 = 2;
        int i18 = 3;
        boolean z18 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, this, container, elementGroupList, option, parseOption, markdownRender);
        }
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(elementGroupList, "elementGroupList");
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(parseOption, "parseOption");
        Intrinsics.checkNotNullParameter(markdownRender, "markdownRender");
        Context context2 = r252.getContext();
        ArrayList<com.tencent.android.androidbypass.viewgroup.render.a> arrayList2 = new ArrayList<>();
        int i19 = 0;
        for (Object obj : elementGroupList) {
            int i26 = i19 + 1;
            if (i19 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            b bVar = (b) obj;
            if (bVar.b() == i17) {
                for (Element element : bVar.a()) {
                    if (element.type == Element.Type.LINK) {
                        com.tencent.android.androidbypass.parser.api.d a16 = com.tencent.android.androidbypass.parser.api.d.INSTANCE.a(element.getStringAttribute(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK));
                        if (a16 != null) {
                            for (ut.a aVar : this.bypass.mOptions.f71935g) {
                                if (aVar.a(a16.e())) {
                                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                                    Bypass.f fVar2 = this.bypass.mOptions;
                                    Intrinsics.checkNotNullExpressionValue(fVar2, "bypass.mOptions");
                                    View b16 = aVar.b(context2, fVar2, a16, "", markdownRender.getMaxWidth());
                                    markdownRender.c(b16);
                                    container.addView(b16);
                                    arrayList2.add(new com.tencent.android.androidbypass.viewgroup.render.a(b16, null));
                                }
                            }
                        } else {
                            z18 = true;
                        }
                    }
                    z18 = true;
                    i17 = 2;
                    c17 = 4;
                }
                arrayList = arrayList2;
                context = context2;
                z17 = z18;
                i3 = i18;
                i16 = i17;
                c16 = c17;
            } else {
                if (bVar.b() == i18) {
                    for (Element element2 : bVar.a()) {
                        if (element2.type == Element.Type.CUSTOM_SYNTAX && (attribute = element2.getAttributes().get(Element.CUSTOM_ELEMENT)) != null && (customElement = attribute.getCustomElement()) != null && (it = customElement.getReplaceElement()) != null) {
                            Intrinsics.checkNotNullExpressionValue(context2, "context");
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            String replaceNodeId = it.getReplaceNodeId();
                            Intrinsics.checkNotNullExpressionValue(replaceNodeId, "it.replaceNodeId");
                            String text = it.getText();
                            Intrinsics.checkNotNullExpressionValue(text, "it.text");
                            View b17 = markdownRender.b(context2, replaceNodeId, text);
                            if (b17 != null) {
                                markdownRender.c(b17);
                                container.addView(b17);
                                arrayList2.add(new com.tencent.android.androidbypass.viewgroup.render.a(b17, null));
                            }
                        }
                    }
                    arrayList = arrayList2;
                    context = context2;
                    i3 = i18;
                    z16 = false;
                    z17 = true;
                    i16 = 2;
                    c16 = 4;
                } else {
                    char c18 = 4;
                    if (bVar.b() == 4) {
                        try {
                            fVar = (f) (!(bVar instanceof f) ? null : bVar);
                        } catch (Exception e17) {
                            com.tencent.android.androidbypass.config.a.f72049a.i("BypassV2", "[renderMarkdown]: " + e17);
                        }
                        if (fVar != null && (e16 = fVar.e()) != null) {
                            Intrinsics.checkNotNullExpressionValue(context2, "context");
                            View h16 = e16.h(context2, markdownRender.getRichUIFactory().a(), markdownRender.a());
                            if (h16 != null) {
                                markdownRender.c(h16);
                                container.addView(h16);
                                if (!(bVar instanceof f)) {
                                    bVar = null;
                                }
                                f fVar3 = (f) bVar;
                                arrayList2.add(new com.tencent.android.androidbypass.viewgroup.render.a(h16, fVar3 != null ? fVar3.e() : null));
                                Unit unit = Unit.INSTANCE;
                                arrayList = arrayList2;
                                context = context2;
                                i3 = i18;
                                c16 = 4;
                                z16 = false;
                                z17 = true;
                                i16 = 2;
                            }
                        }
                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                        TextView f16 = markdownRender.f(context2);
                        markdownRender.e(f16);
                        f16.setText(markdownRender.d());
                        container.addView(f16);
                        arrayList2.add(new com.tencent.android.androidbypass.viewgroup.render.a(f16, null));
                        arrayList = arrayList2;
                        context = context2;
                        i3 = i18;
                        c16 = 4;
                        z16 = false;
                        z17 = true;
                        i16 = 2;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                        TextView f17 = markdownRender.f(context2);
                        f17.setMovementMethod(com.tencent.android.androidbypass.enhance.method.b.a());
                        Integer valueOf = Integer.valueOf(option.i().a());
                        if (!(valueOf.intValue() != 0)) {
                            valueOf = null;
                        }
                        if (valueOf != null) {
                            f17.setLinkTextColor(ResourcesCompat.getColorStateList(f17.getResources(), valueOf.intValue(), null));
                            Unit unit2 = Unit.INSTANCE;
                        }
                        boolean z19 = false;
                        f17.setHighlightColor(0);
                        f17.setAutoLinkMask(0);
                        Unit unit3 = Unit.INSTANCE;
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        for (Element element3 : bVar.a()) {
                            SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
                            spannableStringBuilder2.append(this.bypass.recurseElement(element3, element3.getIndexInParentInfo().a(), element3.getIndexInParentInfo().b(), option.e(), f17, option.i().b(), Boolean.valueOf(element3.getIndexInParentInfo().c()), parseOption, markdownRender));
                            f17 = f17;
                            context2 = context2;
                            spannableStringBuilder = spannableStringBuilder2;
                            arrayList2 = arrayList2;
                            i18 = i18;
                            c18 = c18;
                            r9 = null;
                            z19 = false;
                        }
                        SpannableStringBuilder spannableStringBuilder3 = spannableStringBuilder;
                        ArrayList<com.tencent.android.androidbypass.viewgroup.render.a> arrayList3 = arrayList2;
                        Context context3 = context2;
                        i3 = i18;
                        TextView textView = f17;
                        c16 = c18;
                        z17 = true;
                        i16 = 2;
                        if (spannableStringBuilder3.toString().equals("\n")) {
                            View view = new View(context3);
                            Resources resources = context3.getResources();
                            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
                            view.setLayoutParams(new ConstraintLayout.LayoutParams(0, m(resources.getDisplayMetrics(), 1, 8.0f)));
                            markdownRender.c(view);
                            arrayList = arrayList3;
                            arrayList.add(new com.tencent.android.androidbypass.viewgroup.render.a(view, null));
                            Unit unit4 = Unit.INSTANCE;
                            context = context3;
                            container = r252;
                            container.addView(view);
                        } else {
                            context = context3;
                            arrayList = arrayList3;
                            container = r252;
                            if (spannableStringBuilder3.length() > 0) {
                                if (spannableStringBuilder3.charAt(0) == '\n') {
                                    spannableStringBuilder3.delete(0, 1);
                                }
                                i b18 = option.i().b();
                                Resources resources2 = textView.getResources();
                                Intrinsics.checkNotNullExpressionValue(resources2, "textView.resources");
                                int m3 = m(resources2.getDisplayMetrics(), b18.f72182d, b18.f72180c);
                                TextPaint paint = textView.getPaint();
                                Intrinsics.checkNotNullExpressionValue(paint, "textView.paint");
                                z16 = false;
                                spannableStringBuilder3.setSpan(new com.tencent.android.androidbypass.span.c(m3, paint), 0, spannableStringBuilder3.length(), 33);
                                option.i().b().b(new WeakReference<>(textView));
                                container.addView(textView);
                                markdownRender.e(textView);
                                textView.setText(spannableStringBuilder3);
                                arrayList.add(new com.tencent.android.androidbypass.viewgroup.render.a(textView, spannableStringBuilder3));
                                if (i19 <= 0) {
                                    continue;
                                } else {
                                    ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                                    if (layoutParams != null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                                        Resources resources3 = context.getResources();
                                        Intrinsics.checkNotNullExpressionValue(resources3, "context.resources");
                                        marginLayoutParams.topMargin = m(resources3.getDisplayMetrics(), b18.f72182d, b18.f72180c);
                                        textView.setLayoutParams(marginLayoutParams);
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                                    }
                                }
                            }
                        }
                    }
                }
                arrayList2 = arrayList;
                context2 = context;
                z18 = z17;
                i18 = i3;
                i17 = i16;
                c17 = c16;
                i19 = i26;
            }
            z16 = false;
            arrayList2 = arrayList;
            context2 = context;
            z18 = z17;
            i18 = i3;
            i17 = i16;
            c17 = c16;
            i19 = i26;
        }
        return arrayList2;
    }
}
