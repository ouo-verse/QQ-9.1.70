package oi1;

import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.msg.hummer.servtype.InlineKeyboardMsg$Action;
import tencent.im.msg.hummer.servtype.InlineKeyboardMsg$Button;
import tencent.im.msg.hummer.servtype.InlineKeyboardMsg$InlineKeyboard;
import tencent.im.msg.hummer.servtype.InlineKeyboardMsg$Permission;
import tencent.im.msg.hummer.servtype.InlineKeyboardMsg$Row;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0005\u0003\u0011\u0018\u0019\u001aB\u001d\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0004\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Loi1/c;", "", "", "a", "toString", "", "hashCode", "other", "", "equals", "", "J", "getBotAppid", "()J", "botAppid", "", "Loi1/c$e;", "b", "[Loi1/c$e;", "getRows", "()[Loi1/c$e;", "rows", "<init>", "(J[Loi1/c$e;)V", "c", "d", "e", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: oi1.c, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class InnerKeyboardInfo {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final String f422706d = "";

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final JSONObject f422707e = new JSONObject();

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final JSONArray f422708f = new JSONArray();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long botAppid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Row[] rows;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002B7\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\b\u0012\u0006\u0010#\u001a\u00020\u001e\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0002\u001a\u00020\u0001H\u0016J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0002\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u0017\u0010\u001d\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Loi1/c$a;", "", "a", "", "toString", "", "hashCode", "other", "", "equals", "I", "getType", "()I", "type", "b", "getClickLimit", "clickLimit", "c", "Ljava/lang/String;", "getUnSupportTips", "()Ljava/lang/String;", "unSupportTips", "d", "getData", "data", "e", "Z", "getAtBotShowChannelList", "()Z", "atBotShowChannelList", "Loi1/c$d;", "f", "Loi1/c$d;", "getPermission", "()Loi1/c$d;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "<init>", "(IILjava/lang/String;Ljava/lang/String;ZLoi1/c$d;)V", "g", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: oi1.c$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class Action {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int type;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int clickLimit;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String unSupportTips;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String data;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean atBotShowChannelList;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Permission permission;

        public Action(int i3, int i16, @NotNull String unSupportTips, @NotNull String data, boolean z16, @NotNull Permission permission) {
            Intrinsics.checkNotNullParameter(unSupportTips, "unSupportTips");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(permission, "permission");
            this.type = i3;
            this.clickLimit = i16;
            this.unSupportTips = unSupportTips;
            this.data = data;
            this.atBotShowChannelList = z16;
            this.permission = permission;
        }

        @NotNull
        public Object a() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("TYPE", this.type);
            jSONObject.put("CLICKLIMIT", this.clickLimit);
            jSONObject.put("UNSUPPORTEDTIPS", this.unSupportTips);
            jSONObject.put("DATA", this.data);
            jSONObject.put("ATBOTSHOWCHANNELLIST", this.atBotShowChannelList);
            jSONObject.put("PERMISSION", this.permission.a());
            return jSONObject;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Action)) {
                return false;
            }
            Action action = (Action) other;
            if (this.type == action.type && this.clickLimit == action.clickLimit && Intrinsics.areEqual(this.unSupportTips, action.unSupportTips) && Intrinsics.areEqual(this.data, action.data) && this.atBotShowChannelList == action.atBotShowChannelList && Intrinsics.areEqual(this.permission, action.permission)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((((this.type * 31) + this.clickLimit) * 31) + this.unSupportTips.hashCode()) * 31) + this.data.hashCode()) * 31;
            boolean z16 = this.atBotShowChannelList;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((hashCode + i3) * 31) + this.permission.hashCode();
        }

        @NotNull
        public String toString() {
            return "Action(type=" + this.type + ", clickLimit=" + this.clickLimit + ", unSupportTips=" + this.unSupportTips + ", data=" + this.data + ", atBotShowChannelList=" + this.atBotShowChannelList + ", permission=" + this.permission + ')';
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002B/\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0002\u001a\u00020\u0001H\u0016J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0002\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Loi1/c$b;", "", "a", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "b", "getLabel", "label", "c", "getVisitedLabel", "visitedLabel", "d", "I", "getStyle", "()I", "style", "Loi1/c$a;", "e", "Loi1/c$a;", "getAction", "()Loi1/c$a;", "action", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILoi1/c$a;)V", "f", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: oi1.c$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class Button {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String label;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String visitedLabel;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int style;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Action action;

        public Button(@NotNull String id5, @NotNull String label, @NotNull String visitedLabel, int i3, @NotNull Action action) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(visitedLabel, "visitedLabel");
            Intrinsics.checkNotNullParameter(action, "action");
            this.id = id5;
            this.label = label;
            this.visitedLabel = visitedLabel;
            this.style = i3;
            this.action = action;
        }

        @NotNull
        public Object a() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ID", this.id);
            jSONObject.put("LABEL", this.label);
            jSONObject.put("VISITEDLABEL", this.visitedLabel);
            jSONObject.put("STYLE", this.style);
            jSONObject.put("ACTION", this.action.a());
            return jSONObject;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Button)) {
                return false;
            }
            Button button = (Button) other;
            if (Intrinsics.areEqual(this.id, button.id) && Intrinsics.areEqual(this.label, button.label) && Intrinsics.areEqual(this.visitedLabel, button.visitedLabel) && this.style == button.style && Intrinsics.areEqual(this.action, button.action)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.id.hashCode() * 31) + this.label.hashCode()) * 31) + this.visitedLabel.hashCode()) * 31) + this.style) * 31) + this.action.hashCode();
        }

        @NotNull
        public String toString() {
            return "Button(id=" + this.id + ", label=" + this.label + ", visitedLabel=" + this.visitedLabel + ", style=" + this.style + ", action=" + this.action + ')';
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b0\u00101J#\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b$\u0010\u000eR\u0014\u0010%\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010\u000eR\u0014\u0010&\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010\u000eR\u0014\u0010'\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010\u000eR\u0014\u0010(\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b(\u0010\u000eR\u0014\u0010)\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b)\u0010\u000eR\u0014\u0010*\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b*\u0010\u000eR\u0014\u0010+\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b+\u0010\u000eR\u0014\u0010,\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b,\u0010\u000eR\u0014\u0010-\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b-\u0010\u000eR\u0014\u0010.\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b.\u0010\u000eR\u0014\u0010/\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b/\u0010\u000e\u00a8\u00062"}, d2 = {"Loi1/c$c;", "", "T", "", HippyControllerProps.ARRAY, "Lorg/json/JSONArray;", "c", "([Ljava/lang/Object;)Lorg/json/JSONArray;", "Ltencent/im/msg/hummer/servtype/InlineKeyboardMsg$InlineKeyboard;", "innerKeyboard", "Loi1/c;", "b", "", "ACTION", "Ljava/lang/String;", "ATBOTSHOWCHANNELLIST", "BOTAPPID", "CLICKLIMIT", "DATA", "", "DEDAULT_INT", "I", "DEDAULT_JSONARRAY", "Lorg/json/JSONArray;", "", "DEFAULT_BOOLEAN", "Z", "", "DEFAULT_DOUBLE", "D", "Lorg/json/JSONObject;", "DEFAULT_JSON", "Lorg/json/JSONObject;", "", "DEFAULT_LONG", "J", "DEFAULT_STRING", "ID", "INNERKEYBOARDINFO", "LABEL", "PERMISSION", "ROW", "SPECIFYROLEIDS", "SPECIFYTINYIDS", "STYLE", "TYPE", "UNSUPPORTEDTIPS", "VISITEDLABEL", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: oi1.c$c, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <T> JSONArray c(T[] array) {
            JSONArray jSONArray = new JSONArray();
            for (T t16 : array) {
                jSONArray.mo162put(t16);
            }
            return jSONArray;
        }

        @NotNull
        public final InnerKeyboardInfo b(@NotNull InlineKeyboardMsg$InlineKeyboard innerKeyboard) {
            Intrinsics.checkNotNullParameter(innerKeyboard, "innerKeyboard");
            ArrayList arrayList = new ArrayList();
            long j3 = innerKeyboard.bot_appid.get();
            Iterator<InlineKeyboardMsg$Row> it = innerKeyboard.rows.get().iterator();
            while (it.hasNext()) {
                InlineKeyboardMsg$Row next = it.next();
                ArrayList arrayList2 = new ArrayList();
                Iterator<InlineKeyboardMsg$Button> it5 = next.buttons.get().iterator();
                while (it5.hasNext()) {
                    InlineKeyboardMsg$Button next2 = it5.next();
                    String str = next2.f435951id.get();
                    Intrinsics.checkNotNullExpressionValue(str, "pbBtn.id.get()");
                    String str2 = next2.render_data.label.get();
                    Intrinsics.checkNotNullExpressionValue(str2, "pbBtn.render_data.label.get()");
                    String visitedLabel = next2.render_data.visited_label.get();
                    int i3 = next2.render_data.style.get();
                    InlineKeyboardMsg$Action inlineKeyboardMsg$Action = next2.action.get();
                    int i16 = inlineKeyboardMsg$Action.type.get();
                    String unSupportTips = inlineKeyboardMsg$Action.unsupport_tips.get();
                    int i17 = inlineKeyboardMsg$Action.click_limit.get();
                    String data = inlineKeyboardMsg$Action.data.get();
                    boolean z16 = inlineKeyboardMsg$Action.at_bot_show_channel_list.get();
                    InlineKeyboardMsg$Permission inlineKeyboardMsg$Permission = inlineKeyboardMsg$Action.permission.get();
                    int i18 = inlineKeyboardMsg$Permission.type.get();
                    List<String> list = inlineKeyboardMsg$Permission.specify_role_ids.get();
                    Iterator<InlineKeyboardMsg$Row> it6 = it;
                    Intrinsics.checkNotNullExpressionValue(list, "permissionPb.specify_role_ids.get()");
                    Iterator<InlineKeyboardMsg$Button> it7 = it5;
                    Object[] array = list.toArray(new String[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    List<String> list2 = inlineKeyboardMsg$Permission.specify_tinyids.get();
                    Intrinsics.checkNotNullExpressionValue(list2, "permissionPb.specify_tinyids.get()");
                    Object[] array2 = list2.toArray(new String[0]);
                    Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    Permission permission = new Permission(i18, (String[]) array, (String[]) array2);
                    Intrinsics.checkNotNullExpressionValue(unSupportTips, "unSupportTips");
                    Intrinsics.checkNotNullExpressionValue(data, "data");
                    Action action = new Action(i16, i17, unSupportTips, data, z16, permission);
                    Intrinsics.checkNotNullExpressionValue(visitedLabel, "visitedLabel");
                    arrayList2.add(new Button(str, str2, visitedLabel, i3, action));
                    it = it6;
                    it5 = it7;
                }
                Object[] array3 = arrayList2.toArray(new Button[0]);
                Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                arrayList.add(new Row((Button[]) array3));
                it = it;
            }
            Object[] array4 = arrayList.toArray(new Row[0]);
            Intrinsics.checkNotNull(array4, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return new InnerKeyboardInfo(j3, (Row[]) array4);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\f\b\u0086\b\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003B/\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Loi1/c$d;", "", "Lorg/json/JSONObject;", "a", "", "toString", "", "hashCode", "other", "", "equals", "I", "getType", "()I", "type", "", "b", "[Ljava/lang/String;", "getSpecifyRoleIds", "()[Ljava/lang/String;", "specifyRoleIds", "c", "getSpecifyTinyIds", "specifyTinyIds", "<init>", "(I[Ljava/lang/String;[Ljava/lang/String;)V", "d", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: oi1.c$d, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class Permission {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int type;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String[] specifyRoleIds;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String[] specifyTinyIds;

        public Permission(int i3, @Nullable String[] strArr, @Nullable String[] strArr2) {
            this.type = i3;
            this.specifyRoleIds = strArr;
            this.specifyTinyIds = strArr2;
        }

        @NotNull
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("TYPE", this.type);
            String[] strArr = this.specifyRoleIds;
            if (strArr != null) {
                jSONObject.put("SPECIFYROLEIDS", InnerKeyboardInfo.INSTANCE.c(strArr));
            }
            String[] strArr2 = this.specifyTinyIds;
            if (strArr2 != null) {
                jSONObject.put("SPECIFYTINYIDS", InnerKeyboardInfo.INSTANCE.c(strArr2));
            }
            return jSONObject;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Permission)) {
                return false;
            }
            Permission permission = (Permission) other;
            if (this.type == permission.type && Intrinsics.areEqual(this.specifyRoleIds, permission.specifyRoleIds) && Intrinsics.areEqual(this.specifyTinyIds, permission.specifyTinyIds)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int i3 = this.type * 31;
            String[] strArr = this.specifyRoleIds;
            int i16 = 0;
            if (strArr == null) {
                hashCode = 0;
            } else {
                hashCode = Arrays.hashCode(strArr);
            }
            int i17 = (i3 + hashCode) * 31;
            String[] strArr2 = this.specifyTinyIds;
            if (strArr2 != null) {
                i16 = Arrays.hashCode(strArr2);
            }
            return i17 + i16;
        }

        @NotNull
        public String toString() {
            return "Permission(type=" + this.type + ", specifyRoleIds=" + Arrays.toString(this.specifyRoleIds) + ", specifyTinyIds=" + Arrays.toString(this.specifyTinyIds) + ')';
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0001H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Loi1/c$e;", "", "Loi1/c$b;", "a", "", "toString", "", "hashCode", "other", "", "equals", "", "[Loi1/c$b;", "getButtons", "()[Loi1/c$b;", "buttons", "<init>", "([Loi1/c$b;)V", "b", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: oi1.c$e, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class Row {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Button[] buttons;

        public Row(@NotNull Button[] buttons) {
            Intrinsics.checkNotNullParameter(buttons, "buttons");
            this.buttons = buttons;
        }

        @NotNull
        public Object a() {
            JSONArray jSONArray = new JSONArray();
            for (Button button : this.buttons) {
                jSONArray.mo162put(button.a());
            }
            return jSONArray;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof Row) && Intrinsics.areEqual(this.buttons, ((Row) other).buttons)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.buttons);
        }

        @NotNull
        public String toString() {
            return "Row(buttons=" + Arrays.toString(this.buttons) + ')';
        }
    }

    public InnerKeyboardInfo(long j3, @NotNull Row[] rows) {
        Intrinsics.checkNotNullParameter(rows, "rows");
        this.botAppid = j3;
        this.rows = rows;
    }

    @NotNull
    public final String a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("BOTAPPID", this.botAppid);
        JSONArray jSONArray = new JSONArray();
        for (Row row : this.rows) {
            jSONArray.mo162put(row.a());
        }
        jSONObject.put("ROW", jSONArray);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InnerKeyboardInfo)) {
            return false;
        }
        InnerKeyboardInfo innerKeyboardInfo = (InnerKeyboardInfo) other;
        if (this.botAppid == innerKeyboardInfo.botAppid && Intrinsics.areEqual(this.rows, innerKeyboardInfo.rows)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (androidx.fragment.app.a.a(this.botAppid) * 31) + Arrays.hashCode(this.rows);
    }

    @NotNull
    public String toString() {
        return "InnerKeyboardInfo(botAppid=" + this.botAppid + ", rows=" + Arrays.toString(this.rows) + ')';
    }
}
