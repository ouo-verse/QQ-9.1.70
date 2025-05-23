package com.tencent.android.androidbypass;

import com.tencent.ams.dsdk.monitor.metric.event.TagValue;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.bypass.nativeinterface.Attribute;
import com.tencent.bypass.nativeinterface.CodeElement;
import com.tencent.bypass.nativeinterface.CodeNode;
import com.tencent.bypass.nativeinterface.CustomElement;
import com.tencent.bypass.nativeinterface.StrElement;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 82\u00020\u0001:\u00029:B\u0019\u0012\u0006\u00102\u001a\u000201\u0012\b\u00104\u001a\u0004\u0018\u00010\u0000\u00a2\u0006\u0004\b6\u00107J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00002\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0000J\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u0005j\b\u0012\u0004\u0012\u00020\u0000`\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR3\u0010!\u001a\u001e\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u001f*\u0004\u0018\u00010 0 0\u001e8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0017\u0010-\u001a\u00020,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00104\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Lcom/tencent/android/androidbypass/Element;", "", "", "name", "getStringAttribute", "Ljava/util/ArrayList;", "Lcom/tencent/bypass/nativeinterface/CodeNode;", "Lkotlin/collections/ArrayList;", "getCodeAttribute", "Lcom/tencent/bypass/nativeinterface/CustomElement;", "getCustomElement", "", "index", "getElementIndexInParent", "copyWithoutChild", "toString", "text", "Ljava/lang/String;", Node.CHILDREN_ATTR, "Ljava/util/ArrayList;", "Lcom/tencent/android/androidbypass/Element$Type;", "type", "Lcom/tencent/android/androidbypass/Element$Type;", "", TagValue.IGNORE, "Z", "getIgnore", "()Z", "setIgnore", "(Z)V", "Ljava/util/HashMap;", "kotlin.jvm.PlatformType", "Lcom/tencent/bypass/nativeinterface/Attribute;", "attributes", "Ljava/util/HashMap;", "getAttributes", "()Ljava/util/HashMap;", "Lcom/tencent/android/androidbypass/Document;", "document", "Lcom/tencent/android/androidbypass/Document;", "getDocument", "()Lcom/tencent/android/androidbypass/Document;", "setDocument", "(Lcom/tencent/android/androidbypass/Document;)V", "Lcom/tencent/android/androidbypass/f;", "indexInParentInfo", "Lcom/tencent/android/androidbypass/f;", "getIndexInParentInfo", "()Lcom/tencent/android/androidbypass/f;", "Lcom/tencent/bypass/nativeinterface/Element;", "jniElement", "Lcom/tencent/bypass/nativeinterface/Element;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/android/androidbypass/Element;", "<init>", "(Lcom/tencent/bypass/nativeinterface/Element;Lcom/tencent/android/androidbypass/Element;)V", "Companion", "a", "Type", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class Element {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String CUSTOM_ELEMENT = "custom_element";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final int F_LIST_ORDERED = 1;

    @NotNull
    private final HashMap<String, Attribute> attributes;

    @JvmField
    @NotNull
    public final ArrayList<Element> children;

    @Nullable
    private Document document;
    private boolean ignore;

    @NotNull
    private final f indexInParentInfo;
    private final com.tencent.bypass.nativeinterface.Element jniElement;

    @JvmField
    @Nullable
    public Element parent;

    @JvmField
    @NotNull
    public final String text;

    @JvmField
    @NotNull
    public final Type type;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%\u00a8\u0006&"}, d2 = {"Lcom/tencent/android/androidbypass/Element$Type;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "", "isBlock", "Z", "()Z", "<init>", "(Ljava/lang/String;IIZ)V", "Companion", "a", "BLOCK_CODE", "BLOCK_QUOTE", "BLOCK_HTML", "HEADER", "HRULE", "LIST", "LIST_ITEM", "PARAGRAPH", "TABLE", "TABLE_CELL", "TABLE_ROW", "AUTOLINK", "CODE_SPAN", "DOUBLE_EMPHASIS", "EMPHASIS", "IMAGE", "LINEBREAK", "LINK", "RAW_HTML_TAG", "TRIPLE_EMPHASIS", "TEXT", "STRIKETHROUGH", "CUSTOM_SYNTAX", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class Type {
        private static final /* synthetic */ Type[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final Type AUTOLINK;
        public static final Type BLOCK_CODE;
        public static final Type BLOCK_HTML;
        public static final Type BLOCK_QUOTE;
        public static final Type CODE_SPAN;
        public static final Type CUSTOM_SYNTAX;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final Type DOUBLE_EMPHASIS;
        public static final Type EMPHASIS;
        public static final Type HEADER;
        public static final Type HRULE;
        public static final Type IMAGE;
        public static final Type LINEBREAK;
        public static final Type LINK;
        public static final Type LIST;
        public static final Type LIST_ITEM;
        public static final Type PARAGRAPH;
        public static final Type RAW_HTML_TAG;
        public static final Type STRIKETHROUGH;
        public static final Type TABLE;
        public static final Type TABLE_CELL;
        public static final Type TABLE_ROW;
        public static final Type TEXT;
        public static final Type TRIPLE_EMPHASIS;
        private static final Type[] TypeValues;
        private final boolean isBlock;
        private final int value;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/android/androidbypass/Element$Type$a;", "", "", HippyTKDListViewAdapter.X, "Lcom/tencent/android/androidbypass/Element$Type;", "a", "", "TypeValues", "[Lcom/tencent/android/androidbypass/Element$Type;", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
        /* renamed from: com.tencent.android.androidbypass.Element$Type$a, reason: from kotlin metadata */
        /* loaded from: classes3.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }

            @NotNull
            public final Type a(int x16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    for (Type type : Type.TypeValues) {
                        if (type.getValue() == x16) {
                            return type;
                        }
                    }
                    throw new IllegalArgumentException();
                }
                return (Type) iPatchRedirector.redirect((short) 1, (Object) this, x16);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    return;
                }
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11531);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            Type type = new Type("BLOCK_CODE", 0, 0, true);
            BLOCK_CODE = type;
            Type type2 = new Type("BLOCK_QUOTE", 1, 1, true);
            BLOCK_QUOTE = type2;
            Type type3 = new Type("BLOCK_HTML", 2, 2, true);
            BLOCK_HTML = type3;
            Type type4 = new Type("HEADER", 3, 3, true);
            HEADER = type4;
            Type type5 = new Type("HRULE", 4, 4, true);
            HRULE = type5;
            Type type6 = new Type("LIST", 5, 5, true);
            LIST = type6;
            Type type7 = new Type("LIST_ITEM", 6, 6, true);
            LIST_ITEM = type7;
            Type type8 = new Type("PARAGRAPH", 7, 7, true);
            PARAGRAPH = type8;
            Type type9 = new Type("TABLE", 8, 8, true);
            TABLE = type9;
            Type type10 = new Type("TABLE_CELL", 9, 9, true);
            TABLE_CELL = type10;
            Type type11 = new Type("TABLE_ROW", 10, 10, true);
            TABLE_ROW = type11;
            Type type12 = new Type("AUTOLINK", 11, 267, false, 2, null);
            AUTOLINK = type12;
            boolean z16 = false;
            int i3 = 2;
            DefaultConstructorMarker defaultConstructorMarker = null;
            Type type13 = new Type("CODE_SPAN", 12, 268, z16, i3, defaultConstructorMarker);
            CODE_SPAN = type13;
            Type type14 = new Type("DOUBLE_EMPHASIS", 13, 269, z16, i3, defaultConstructorMarker);
            DOUBLE_EMPHASIS = type14;
            Type type15 = new Type("EMPHASIS", 14, 270, z16, i3, defaultConstructorMarker);
            EMPHASIS = type15;
            Type type16 = new Type("IMAGE", 15, 271, z16, i3, defaultConstructorMarker);
            IMAGE = type16;
            Type type17 = new Type("LINEBREAK", 16, 272, z16, i3, defaultConstructorMarker);
            LINEBREAK = type17;
            Type type18 = new Type("LINK", 17, 273, z16, i3, defaultConstructorMarker);
            LINK = type18;
            Type type19 = new Type("RAW_HTML_TAG", 18, 274, z16, i3, defaultConstructorMarker);
            RAW_HTML_TAG = type19;
            Type type20 = new Type("TRIPLE_EMPHASIS", 19, 275, z16, i3, defaultConstructorMarker);
            TRIPLE_EMPHASIS = type20;
            Type type21 = new Type("TEXT", 20, 276, z16, i3, defaultConstructorMarker);
            TEXT = type21;
            Type type22 = new Type("STRIKETHROUGH", 21, 277, z16, i3, defaultConstructorMarker);
            STRIKETHROUGH = type22;
            Type type23 = new Type("CUSTOM_SYNTAX", 22, 278, z16, i3, defaultConstructorMarker);
            CUSTOM_SYNTAX = type23;
            $VALUES = new Type[]{type, type2, type3, type4, type5, type6, type7, type8, type9, type10, type11, type12, type13, type14, type15, type16, type17, type18, type19, type20, type21, type22, type23};
            INSTANCE = new Companion(null);
            TypeValues = values();
        }

        Type(String str, int i3, int i16, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            } else {
                this.value = i16;
                this.isBlock = z16;
            }
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public final int getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.value;
        }

        public final boolean isBlock() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.isBlock;
        }

        /* synthetic */ Type(String str, int i3, int i16, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, i16, (i17 & 2) != 0 ? false : z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/android/androidbypass/Element$a;", "", "", "CUSTOM_ELEMENT", "Ljava/lang/String;", "", "F_LIST_ORDERED", "I", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.Element$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11537);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public Element(@NotNull com.tencent.bypass.nativeinterface.Element jniElement, @Nullable Element element) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(jniElement, "jniElement");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) jniElement, (Object) element);
            return;
        }
        this.jniElement = jniElement;
        this.parent = element;
        String text = jniElement.getText();
        Intrinsics.checkNotNullExpressionValue(text, "jniElement.text");
        this.text = text;
        ArrayList<Element> arrayList = new ArrayList<>();
        ArrayList<com.tencent.bypass.nativeinterface.Element> children = jniElement.getChildren();
        Intrinsics.checkNotNullExpressionValue(children, "jniElement.children");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(children, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (com.tencent.bypass.nativeinterface.Element it : children) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList2.add(new Element(it, this));
        }
        arrayList.addAll(arrayList2);
        Unit unit = Unit.INSTANCE;
        this.children = arrayList;
        this.type = Type.INSTANCE.a(this.jniElement.getType());
        HashMap<String, Attribute> attributes = this.jniElement.getAttributes();
        Intrinsics.checkNotNullExpressionValue(attributes, "jniElement.attributes");
        this.attributes = attributes;
        this.indexInParentInfo = new f(0, false, 0, 7, null);
    }

    @NotNull
    public final Element copyWithoutChild() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Element) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        Element element = new Element(this.jniElement, this.parent);
        element.children.clear();
        element.indexInParentInfo.e(this.indexInParentInfo.a());
        element.indexInParentInfo.f(this.indexInParentInfo.b());
        element.indexInParentInfo.d(this.indexInParentInfo.c());
        return element;
    }

    @NotNull
    public final HashMap<String, Attribute> getAttributes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HashMap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.attributes;
    }

    @Nullable
    public final ArrayList<CodeNode> getCodeAttribute(@NotNull String name) {
        CodeElement codeElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this, (Object) name);
        }
        Intrinsics.checkNotNullParameter(name, "name");
        Attribute attribute = this.attributes.get(name);
        if (attribute != null && (codeElement = attribute.getCodeElement()) != null) {
            return codeElement.getCodeNodes();
        }
        return null;
    }

    @Nullable
    public final CustomElement getCustomElement() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (CustomElement) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        Attribute attribute = this.attributes.get(CUSTOM_ELEMENT);
        if (attribute != null) {
            return attribute.getCustomElement();
        }
        return null;
    }

    @Nullable
    public final Document getDocument() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Document) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.document;
    }

    @Nullable
    public final Element getElementIndexInParent(int index) {
        ArrayList<Element> arrayList;
        Object orNull;
        ArrayList<Element> elements;
        Object orNull2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Element) iPatchRedirector.redirect((short) 10, (Object) this, index);
        }
        Document document = this.document;
        if (document != null && (elements = document.getElements()) != null) {
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(elements, index);
            Element element = (Element) orNull2;
            if (element != null) {
                return element;
            }
        }
        Element element2 = this.parent;
        if (element2 != null && (arrayList = element2.children) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, index);
            return (Element) orNull;
        }
        return null;
    }

    public final boolean getIgnore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        return this.ignore;
    }

    @NotNull
    public final f getIndexInParentInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (f) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.indexInParentInfo;
    }

    @NotNull
    public final String getStringAttribute(@NotNull String name) {
        StrElement strElement;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) name);
        }
        Intrinsics.checkNotNullParameter(name, "name");
        Attribute attribute = this.attributes.get(name);
        if (attribute == null || (strElement = attribute.getStrElement()) == null || (str = strElement.getStr()) == null) {
            return "";
        }
        return str;
    }

    public final void setDocument(@Nullable Document document) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) document);
        } else {
            this.document = document;
        }
    }

    public final void setIgnore(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.ignore = z16;
        }
    }

    @NotNull
    public String toString() {
        String replace$default;
        String trimIndent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\n            { type: ");
        sb5.append(this.type.name());
        sb5.append(",text: ");
        replace$default = StringsKt__StringsJVMKt.replace$default(this.text, "\n", RedTouch.NEWLINE_CHAR, false, 4, (Object) null);
        sb5.append(replace$default);
        sb5.append(", children: ");
        sb5.append(this.children);
        sb5.append(",attr: ");
        sb5.append(this.attributes);
        sb5.append(" }\n        ");
        trimIndent = StringsKt__IndentKt.trimIndent(sb5.toString());
        return trimIndent;
    }
}
