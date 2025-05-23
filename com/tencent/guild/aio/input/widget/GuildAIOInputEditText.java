package com.tencent.guild.aio.input.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import androidx.appcompat.widget.AppCompatEditText;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.guild.aio.input.at.utils.h;
import com.tencent.guild.aio.util.g;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0003()*B\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 B\u001b\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\b\u001f\u0010#B#\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b\u001f\u0010&J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\u000e\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R$\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006+"}, d2 = {"Lcom/tencent/guild/aio/input/widget/GuildAIOInputEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Lcom/tencent/guild/aio/input/widget/GuildAIOInputEditText$d;", "listener", "", "setOnPrivateIMECommandListener", "Landroid/view/KeyEvent;", "event", "", "dispatchKeyEventPreIme", "", "action", "Landroid/os/Bundle;", "data", "onPrivateIMECommand", "srcClassName", "Lcom/tencent/guild/aio/input/at/utils/h;", "setKeyEventPreImeListener", "Landroid/view/inputmethod/EditorInfo;", "outAttrs", "Landroid/view/inputmethod/InputConnection;", "onCreateInputConnection", "", "E", "Ljava/util/Map;", "mKeyEventListenersMap", UserInfo.SEX_FEMALE, "Lcom/tencent/guild/aio/input/widget/GuildAIOInputEditText$d;", "mOnPrivateIMECommandListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "G", "b", "c", "d", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAIOInputEditText extends AppCompatEditText {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private Map<String, h> mKeyEventListenersMap;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private d mOnPrivateIMECommandListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/guild/aio/input/widget/GuildAIOInputEditText$a", "Landroid/text/InputFilter;", "", "source", "", "start", "end", "Landroid/text/Spanned;", "dest", "dstart", "dend", "filter", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements InputFilter {
        a() {
        }

        @Override // android.text.InputFilter
        @Nullable
        public CharSequence filter(@NotNull CharSequence source, int start, int end, @NotNull Spanned dest, int dstart, int dend) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(dest, "dest");
            g.f112400a.b((dest.length() - (dend - dstart)) + (end - start));
            return null;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/guild/aio/input/widget/GuildAIOInputEditText$c;", "Landroid/view/inputmethod/InputConnectionWrapper;", "", "beforeLength", "afterLength", "", "deleteSurroundingText", "Landroid/view/inputmethod/InputConnection;", "target", "mutable", "<init>", "(Lcom/tencent/guild/aio/input/widget/GuildAIOInputEditText;Landroid/view/inputmethod/InputConnection;Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    private final class c extends InputConnectionWrapper {
        public c(@Nullable InputConnection inputConnection, boolean z16) {
            super(inputConnection, z16);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int beforeLength, int afterLength) {
            return GuildAIOInputEditText.this.onKeyDown(67, new KeyEvent(0, 67));
        }

        public /* synthetic */ c(GuildAIOInputEditText guildAIOInputEditText, InputConnection inputConnection, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(inputConnection, (i3 & 2) != 0 ? false : z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/guild/aio/input/widget/GuildAIOInputEditText$d;", "", "", "action", "Landroid/os/Bundle;", "data", "", "onPrivateIMECommand", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public interface d {
        boolean onPrivateIMECommand(@Nullable String action, @Nullable Bundle data);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAIOInputEditText(@NotNull Context context) {
        super(context);
        Map<String, h> mutableMapOf;
        Intrinsics.checkNotNullParameter(context, "context");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("GuildHashtagHelper", null), TuplesKt.to("GuildAtHelper", null), TuplesKt.to("GuildRobotAtHelper", null), TuplesKt.to("GuildSlashHelper", null));
        this.mKeyEventListenersMap = mutableMapOf;
        setFilters(new InputFilter[]{new a(), new InputFilter.LengthFilter(1900)});
    }

    @Override // android.view.View
    public boolean dispatchKeyEventPreIme(@NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        for (h hVar : this.mKeyEventListenersMap.values()) {
            boolean z16 = false;
            if (hVar != null && hVar.a(event)) {
                z16 = true;
            }
            if (z16) {
                return true;
            }
        }
        return super.dispatchKeyEventPreIme(event);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    @NotNull
    public InputConnection onCreateInputConnection(@NotNull EditorInfo outAttrs) {
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        c cVar = new c(this, super.onCreateInputConnection(outAttrs), false, 2, null);
        if ((getInputType() & 131072) == 131072 && getImeOptions() != 0) {
            outAttrs.imeOptions &= -1073741825;
            outAttrs.inputType &= -131073;
        }
        return cVar;
    }

    @Override // android.widget.TextView
    public boolean onPrivateIMECommand(@Nullable String action, @Nullable Bundle data) {
        QLog.i("GuildAIOInputEditText", 1, "onPrivateIMECommand, action:" + action + " data:" + data);
        if (action != null && data != null) {
            d dVar = this.mOnPrivateIMECommandListener;
            if (dVar != null) {
                return dVar.onPrivateIMECommand(action, data);
            }
            return super.onPrivateIMECommand(action, data);
        }
        return super.onPrivateIMECommand(action, data);
    }

    public final void setKeyEventPreImeListener(@NotNull String srcClassName, @Nullable h listener) {
        Intrinsics.checkNotNullParameter(srcClassName, "srcClassName");
        if (this.mKeyEventListenersMap.containsKey(srcClassName)) {
            this.mKeyEventListenersMap.put(srcClassName, listener);
        }
    }

    public final void setOnPrivateIMECommandListener(@NotNull d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mOnPrivateIMECommandListener = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAIOInputEditText(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Map<String, h> mutableMapOf;
        Intrinsics.checkNotNullParameter(context, "context");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("GuildHashtagHelper", null), TuplesKt.to("GuildAtHelper", null), TuplesKt.to("GuildRobotAtHelper", null), TuplesKt.to("GuildSlashHelper", null));
        this.mKeyEventListenersMap = mutableMapOf;
        setFilters(new InputFilter[]{new a(), new InputFilter.LengthFilter(1900)});
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAIOInputEditText(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Map<String, h> mutableMapOf;
        Intrinsics.checkNotNullParameter(context, "context");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("GuildHashtagHelper", null), TuplesKt.to("GuildAtHelper", null), TuplesKt.to("GuildRobotAtHelper", null), TuplesKt.to("GuildSlashHelper", null));
        this.mKeyEventListenersMap = mutableMapOf;
        setFilters(new InputFilter[]{new a(), new InputFilter.LengthFilter(1900)});
    }
}
