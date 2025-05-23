package com.tencent.nativepreview.biz;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\r\u0018\u0000 \u00112\u00020\u0001:\u0001\u0003B/\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/nativepreview/biz/OutlineStyle;", "", "", "a", "I", "getType", "()I", "type", "", "b", UserInfo.SEX_FEMALE, "f", "()F", NodeProps.PADDING_LEFT, "c", "d", "fontSize", "e", "normalColor", "<init>", "(IFFI)V", "native_preview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes21.dex */
public final class OutlineStyle {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final OutlineStyle f337833f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final OutlineStyle f337834g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Map<Integer, OutlineStyle> f337835h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float paddingLeft;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float fontSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int normalColor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0006\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR#\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/nativepreview/biz/OutlineStyle$a;", "", "", "style", "Lcom/tencent/nativepreview/biz/OutlineStyle;", "c", "STYLE_HEADING1", "Lcom/tencent/nativepreview/biz/OutlineStyle;", "d", "()Lcom/tencent/nativepreview/biz/OutlineStyle;", "DEFAULT_STYLE", "b", "", "ALL_OUTLINE_STYLES", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "", "DEFAULT_FONT_SIZE", UserInfo.SEX_FEMALE, "DEFAULT_HEADING_FONT_SIZE", "DEFAULT_PADDING_LEFT", "<init>", "()V", "native_preview_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.nativepreview.biz.OutlineStyle$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final Map<Integer, OutlineStyle> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return OutlineStyle.f337835h;
            }
            return (Map) iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @NotNull
        public final OutlineStyle b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return OutlineStyle.f337834g;
            }
            return (OutlineStyle) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @NotNull
        public final OutlineStyle c(int style) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (OutlineStyle) iPatchRedirector.redirect((short) 5, (Object) this, style);
            }
            OutlineStyle outlineStyle = a().get(Integer.valueOf(style));
            if (outlineStyle == null) {
                return OutlineStyle.INSTANCE.b();
            }
            return outlineStyle;
        }

        @NotNull
        public final OutlineStyle d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return OutlineStyle.f337833f;
            }
            return (OutlineStyle) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14723);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        INSTANCE = new Companion(null);
        OutlineStyle outlineStyle = new OutlineStyle(4, 48.0f, 16.0f, -1560281088);
        f337833f = outlineStyle;
        f337834g = outlineStyle;
        f337835h = new HashMap<Integer, OutlineStyle>() { // from class: com.tencent.nativepreview.biz.OutlineStyle$Companion$ALL_OUTLINE_STYLES$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                put(2, new OutlineStyle(2, 16.0f, 18.0f, -536870912));
                put(3, new OutlineStyle(3, 48.0f, 17.0f, -1560281088));
                put(4, OutlineStyle.INSTANCE.d());
                put(5, new OutlineStyle(5, 64.0f, 14.0f, -1560281088));
                put(6, new OutlineStyle(6, 80.0f, 14.0f, -1560281088));
                put(7, new OutlineStyle(7, 96.0f, 14.0f, -1560281088));
                put(8, new OutlineStyle(8, 112.0f, 14.0f, -1560281088));
                put(9, new OutlineStyle(9, 128.0f, 14.0f, -1560281088));
            }

            public /* bridge */ boolean containsKey(Integer num) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? super.containsKey((Object) num) : ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) num)).booleanValue();
            }

            public /* bridge */ boolean containsValue(OutlineStyle outlineStyle2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? super.containsValue((Object) outlineStyle2) : ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) outlineStyle2)).booleanValue();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<Map.Entry<Integer, OutlineStyle>> entrySet() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                    return (Set) iPatchRedirector.redirect((short) 15, (Object) this);
                }
                return getEntries();
            }

            public /* bridge */ OutlineStyle get(Integer num) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? (OutlineStyle) super.get((Object) num) : (OutlineStyle) iPatchRedirector.redirect((short) 2, (Object) this, (Object) num);
            }

            public /* bridge */ Set<Map.Entry<Integer, OutlineStyle>> getEntries() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                    return (Set) iPatchRedirector.redirect((short) 14, (Object) this);
                }
                return super.entrySet();
            }

            public /* bridge */ Set<Integer> getKeys() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                    return (Set) iPatchRedirector.redirect((short) 16, (Object) this);
                }
                return super.keySet();
            }

            public /* bridge */ OutlineStyle getOrDefault(Integer num, OutlineStyle outlineStyle2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? (OutlineStyle) super.getOrDefault((Object) num, (Integer) outlineStyle2) : (OutlineStyle) iPatchRedirector.redirect((short) 4, (Object) this, (Object) num, (Object) outlineStyle2);
            }

            public /* bridge */ int getSize() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                    return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
                }
                return super.size();
            }

            public /* bridge */ Collection<OutlineStyle> getValues() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                    return (Collection) iPatchRedirector.redirect((short) 20, (Object) this);
                }
                return super.values();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<Integer> keySet() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                    return (Set) iPatchRedirector.redirect((short) 17, (Object) this);
                }
                return getKeys();
            }

            public /* bridge */ OutlineStyle remove(Integer num) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? (OutlineStyle) super.remove((Object) num) : (OutlineStyle) iPatchRedirector.redirect((short) 6, (Object) this, (Object) num);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ int size() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                    return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
                }
                return getSize();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Collection<OutlineStyle> values() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                    return (Collection) iPatchRedirector.redirect((short) 21, (Object) this);
                }
                return getValues();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsKey(Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, obj)).booleanValue();
                }
                if (obj instanceof Integer) {
                    return containsKey((Integer) obj);
                }
                return false;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsValue(Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, obj)).booleanValue();
                }
                if (obj instanceof OutlineStyle) {
                    return containsValue((OutlineStyle) obj);
                }
                return false;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ OutlineStyle get(Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (OutlineStyle) iPatchRedirector.redirect((short) 3, (Object) this, obj);
                }
                if (obj instanceof Integer) {
                    return get((Integer) obj);
                }
                return null;
            }

            public final /* bridge */ OutlineStyle getOrDefault(Object obj, OutlineStyle outlineStyle2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? !(obj instanceof Integer) ? outlineStyle2 : getOrDefault((Integer) obj, outlineStyle2) : (OutlineStyle) iPatchRedirector.redirect((short) 5, (Object) this, obj, (Object) outlineStyle2);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ OutlineStyle remove(Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return (OutlineStyle) iPatchRedirector.redirect((short) 7, (Object) this, obj);
                }
                if (obj instanceof Integer) {
                    return remove((Integer) obj);
                }
                return null;
            }

            public /* bridge */ boolean remove(Integer num, OutlineStyle outlineStyle2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? super.remove((Object) num, (Object) outlineStyle2) : ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) num, (Object) outlineStyle2)).booleanValue();
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ boolean remove(Object obj, Object obj2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, obj, obj2)).booleanValue();
                }
                if ((obj instanceof Integer) && (obj2 instanceof OutlineStyle)) {
                    return remove((Integer) obj, (OutlineStyle) obj2);
                }
                return false;
            }
        };
    }

    public OutlineStyle() {
        this(0, 0.0f, 0.0f, 0, 15, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this);
    }

    public final float d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
        }
        return this.fontSize;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.normalColor;
    }

    public final float f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
        }
        return this.paddingLeft;
    }

    public OutlineStyle(int i3, float f16, float f17, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i16));
            return;
        }
        this.type = i3;
        this.paddingLeft = f16;
        this.fontSize = f17;
        this.normalColor = i16;
    }

    public /* synthetic */ OutlineStyle(int i3, float f16, float f17, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? 0.0f : f16, (i17 & 4) == 0 ? f17 : 0.0f, (i17 & 8) != 0 ? 0 : i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
    }
}
