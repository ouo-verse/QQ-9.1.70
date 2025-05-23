package com.tencent.android.androidbypass.enhance.inlinekeyboard.model;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.sdk.widget.ToastView;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\t\u000fBK\b\u0007\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010!\u001a\u00020\u0007\u0012\b\b\u0002\u0010$\u001a\u00020\u0007\u0012\b\b\u0002\u0010&\u001a\u00020\u0007\u00a2\u0006\u0004\b'\u0010(J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\t\u0010\u0016R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010!\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001d\u001a\u0004\b\u000f\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010$\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\"\u0010&\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b\u0018\u0010\u001e\"\u0004\b%\u0010 \u00a8\u0006)"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "id", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a$b;", "b", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a$b;", "f", "()Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a$b;", "renderData", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a$a;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a$a;", "()Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a$a;", "action", "d", "Ljava/lang/Object;", "e", "()Ljava/lang/Object;", "prototype", "Z", "()Z", h.F, "(Z)V", NodeProps.ENABLED, "g", "j", "selected", "i", ToastView.ICON_LOADING, "<init>", "(Ljava/lang/String;Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a$b;Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a$a;Ljava/lang/Object;ZZZ)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b renderData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C0720a action;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Object prototype;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean enabled;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean selected;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean loading;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001BC\b\u0007\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0007\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\t\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u0017\u0010!\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001a\u001a\u0004\b\u0019\u0010\u001c\u00a8\u0006$"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "type", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/c;", "b", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/c;", "()Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/c;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "getClickLimit", "clickLimit", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "data", "e", "Z", "getAtBotShowChannelList", "()Z", "atBotShowChannelList", "f", "unsupportedTips", "g", "isReply", "<init>", "(ILcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/c;ILjava/lang/String;ZLjava/lang/String;Z)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final /* data */ class C0720a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int type;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final c permission;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int clickLimit;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String data;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean atBotShowChannelList;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String unsupportedTips;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private final boolean isReply;

        @JvmOverloads
        public C0720a(int i3, @NotNull c permission, int i16, @NotNull String data, boolean z16, @NotNull String unsupportedTips, boolean z17) {
            Intrinsics.checkNotNullParameter(permission, "permission");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(unsupportedTips, "unsupportedTips");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), permission, Integer.valueOf(i16), data, Boolean.valueOf(z16), unsupportedTips, Boolean.valueOf(z17));
                return;
            }
            this.type = i3;
            this.permission = permission;
            this.clickLimit = i16;
            this.data = data;
            this.atBotShowChannelList = z16;
            this.unsupportedTips = unsupportedTips;
            this.isReply = z17;
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.data;
        }

        @NotNull
        public final c b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (c) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.permission;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
            }
            return this.type;
        }

        @NotNull
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.unsupportedTips;
        }

        public final boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return this.isReply;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, other)).booleanValue();
            }
            if (this != other) {
                if (other instanceof C0720a) {
                    C0720a c0720a = (C0720a) other;
                    if (this.type != c0720a.type || !Intrinsics.areEqual(this.permission, c0720a.permission) || this.clickLimit != c0720a.clickLimit || !Intrinsics.areEqual(this.data, c0720a.data) || this.atBotShowChannelList != c0720a.atBotShowChannelList || !Intrinsics.areEqual(this.unsupportedTips, c0720a.unsupportedTips) || this.isReply != c0720a.isReply) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
            }
            int i17 = this.type * 31;
            c cVar = this.permission;
            int i18 = 0;
            if (cVar != null) {
                i3 = cVar.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (((i17 + i3) * 31) + this.clickLimit) * 31;
            String str = this.data;
            if (str != null) {
                i16 = str.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 31;
            boolean z16 = this.atBotShowChannelList;
            int i27 = 1;
            int i28 = z16;
            if (z16 != 0) {
                i28 = 1;
            }
            int i29 = (i26 + i28) * 31;
            String str2 = this.unsupportedTips;
            if (str2 != null) {
                i18 = str2.hashCode();
            }
            int i36 = (i29 + i18) * 31;
            boolean z17 = this.isReply;
            if (!z17) {
                i27 = z17 ? 1 : 0;
            }
            return i36 + i27;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (String) iPatchRedirector.redirect((short) 19, (Object) this);
            }
            return "Action(type=" + this.type + ", permission=" + this.permission + ", clickLimit=" + this.clickLimit + ", data=" + this.data + ", atBotShowChannelList=" + this.atBotShowChannelList + ", unsupportedTips=" + this.unsupportedTips + ", isReply=" + this.isReply + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\t\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "label", "e", "visitedLabel", "c", "I", "()I", "style", "", "d", UserInfo.SEX_FEMALE, "()F", "textSize", "buttonHeight", "<init>", "(Ljava/lang/String;Ljava/lang/String;IFI)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String label;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String visitedLabel;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int style;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final float textSize;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int buttonHeight;

        public b(@NotNull String label, @NotNull String visitedLabel, int i3, float f16, int i16) {
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(visitedLabel, "visitedLabel");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, label, visitedLabel, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
                return;
            }
            this.label = label;
            this.visitedLabel = visitedLabel;
            this.style = i3;
            this.textSize = f16;
            this.buttonHeight = i16;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.buttonHeight;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (String) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return this.label;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.style;
        }

        public final float d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
            }
            return this.textSize;
        }

        @NotNull
        public final String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.visitedLabel;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
            }
            if (this != other) {
                if (other instanceof b) {
                    b bVar = (b) other;
                    if (!Intrinsics.areEqual(this.label, bVar.label) || !Intrinsics.areEqual(this.visitedLabel, bVar.visitedLabel) || this.style != bVar.style || Float.compare(this.textSize, bVar.textSize) != 0 || this.buttonHeight != bVar.buttonHeight) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
            }
            String str = this.label;
            int i16 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = i3 * 31;
            String str2 = this.visitedLabel;
            if (str2 != null) {
                i16 = str2.hashCode();
            }
            return ((((((i17 + i16) * 31) + this.style) * 31) + Float.floatToIntBits(this.textSize)) * 31) + this.buttonHeight;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (String) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return "RenderData(label=" + this.label + ", visitedLabel=" + this.visitedLabel + ", style=" + this.style + ", textSize=" + this.textSize + ", buttonHeight=" + this.buttonHeight + ")";
        }

        public /* synthetic */ b(String str, String str2, int i3, float f16, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, i3, (i17 & 8) != 0 ? 0.0f : f16, (i17 & 16) != 0 ? 0 : i16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, this, str, str2, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
        }
    }

    @JvmOverloads
    public a(@NotNull String id5, @NotNull b renderData, @NotNull C0720a action, @Nullable Object obj, boolean z16, boolean z17, boolean z18) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(renderData, "renderData");
        Intrinsics.checkNotNullParameter(action, "action");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, id5, renderData, action, obj, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        this.id = id5;
        this.renderData = renderData;
        this.action = action;
        this.prototype = obj;
        this.enabled = z16;
        this.selected = z17;
        this.loading = z18;
    }

    @NotNull
    public final C0720a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (C0720a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.action;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.enabled;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.id;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.loading;
    }

    @Nullable
    public final Object e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.prototype;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof a) {
                a aVar = (a) other;
                if (!Intrinsics.areEqual(this.id, aVar.id) || !Intrinsics.areEqual(this.renderData, aVar.renderData) || !Intrinsics.areEqual(this.action, aVar.action) || !Intrinsics.areEqual(this.prototype, aVar.prototype) || this.enabled != aVar.enabled || this.selected != aVar.selected || this.loading != aVar.loading) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final b f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.renderData;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.selected;
    }

    public final void h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.enabled = z16;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        String str = this.id;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        b bVar = this.renderData;
        if (bVar != null) {
            i16 = bVar.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        C0720a c0720a = this.action;
        if (c0720a != null) {
            i17 = c0720a.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        Object obj = this.prototype;
        if (obj != null) {
            i18 = obj.hashCode();
        }
        int i28 = (i27 + i18) * 31;
        boolean z16 = this.enabled;
        int i29 = 1;
        int i36 = z16;
        if (z16 != 0) {
            i36 = 1;
        }
        int i37 = (i28 + i36) * 31;
        boolean z17 = this.selected;
        int i38 = z17;
        if (z17 != 0) {
            i38 = 1;
        }
        int i39 = (i37 + i38) * 31;
        boolean z18 = this.loading;
        if (!z18) {
            i29 = z18 ? 1 : 0;
        }
        return i39 + i29;
    }

    public final void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.loading = z16;
        }
    }

    public final void j(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.selected = z16;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return "InlineBtnModel(id=" + this.id + ", renderData=" + this.renderData + ", action=" + this.action + ", prototype=" + this.prototype + ", enabled=" + this.enabled + ", selected=" + this.selected + ", loading=" + this.loading + ")";
    }

    public /* synthetic */ a(String str, b bVar, C0720a c0720a, Object obj, boolean z16, boolean z17, boolean z18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bVar, c0720a, (i3 & 8) != 0 ? null : obj, (i3 & 16) != 0 ? true : z16, (i3 & 32) != 0 ? false : z17, (i3 & 64) != 0 ? false : z18);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return;
        }
        iPatchRedirector.redirect((short) 12, this, str, bVar, c0720a, obj, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
