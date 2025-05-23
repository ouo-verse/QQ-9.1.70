package jo0;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.input.at.hashtag.ui.g;
import com.tencent.guild.aio.input.widget.GuildAIOInputEditText;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import so0.c;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \u001b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b,\u0010-J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0006\u0010\u000b\u001a\u00020\bJ2\u0010\u0016\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0018\u001a\u00020\u0017J&\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0017R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010(R\u0011\u0010+\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b#\u0010*\u00a8\u0006."}, d2 = {"Ljo0/a;", "", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "before", "count", "", "a", "c", "e", "Lcom/tencent/guild/aio/input/widget/GuildAIOInputEditText;", "editText", "Landroid/view/ViewGroup;", "inputContainer", "Landroid/content/Context;", "context", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "Lqp0/a;", "callback", "b", "", h.F, "f", ViewStickEventHelper.IS_SHOW, "g", "Lcom/tencent/guild/aio/input/at/hashtag/ui/g;", "Lcom/tencent/guild/aio/input/at/hashtag/ui/g;", "mGuildHashtagManage", "Lcom/tencent/guild/aio/input/widget/GuildAIOInputEditText;", "mEditText", "Landroid/view/ViewGroup;", "mInputContainer", "d", "Landroid/content/Context;", "mContext", "Lcom/tencent/aio/data/AIOParam;", "mAIOParam", "Lqp0/a;", "mCallback", "()Z", "isShowing", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g mGuildHashtagManage;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildAIOInputEditText mEditText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup mInputContainer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOParam mAIOParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private qp0.a mCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"jo0/a$b", "Lcom/tencent/guild/aio/input/at/utils/h;", "Landroid/view/KeyEvent;", "event", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.guild.aio.input.at.utils.h {
        b() {
        }

        @Override // com.tencent.guild.aio.input.at.utils.h
        public boolean a(@Nullable KeyEvent event) {
            boolean z16;
            if (event != null && event.getKeyCode() == 4) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            return a.this.h();
        }
    }

    private final void a(CharSequence s16, int start, int before, int count) {
        int i3;
        Editable editable;
        int lastIndexOf$default;
        boolean z16;
        GuildAIOInputEditText guildAIOInputEditText = this.mEditText;
        boolean z17 = false;
        if (guildAIOInputEditText != null) {
            i3 = guildAIOInputEditText.getSelectionStart();
        } else {
            i3 = 0;
        }
        int max = Math.max(0, i3);
        GuildAIOInputEditText guildAIOInputEditText2 = this.mEditText;
        Editable editable2 = null;
        if (guildAIOInputEditText2 != null) {
            editable = guildAIOInputEditText2.getEditableText();
        } else {
            editable = null;
        }
        if (editable == null) {
            return;
        }
        int d16 = ko0.a.d(editable, max);
        int i16 = max - 1;
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default(s16, '\n', i16, false, 4, (Object) null);
        if (lastIndexOf$default > d16) {
            d16 = -1;
        }
        if (count == 1 && (s16.charAt(start) == '\uff0a' || s16.charAt(start) == '*')) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (count == 0 && max > 0 && ((s16.charAt(i16) == '\uff0a' || s16.charAt(i16) == '*') && d16 > 0)) {
            z17 = true;
        }
        if (z16 || z17) {
            c();
        }
        int h16 = c.h(this.mEditText);
        if (QLog.isColorLevel()) {
            QLog.d("GuildHashtagHelper", 2, "selectIndex =" + max + " isFirstAddHashtag=" + z16 + " isFirstBackHashtag= max=" + d16 + z17 + " lastSpanHashtag=" + h16 + " mHashtagPanel=mHashtagPanel");
        }
        if (h16 < d16 && d16 >= 0 && this.mGuildHashtagManage != null) {
            GuildAIOInputEditText guildAIOInputEditText3 = this.mEditText;
            if (guildAIOInputEditText3 != null) {
                editable2 = guildAIOInputEditText3.getText();
            }
            String substring = String.valueOf(editable2).substring(d16 + 1, max);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            g gVar = this.mGuildHashtagManage;
            Intrinsics.checkNotNull(gVar);
            gVar.z(this.mInputContainer, substring);
            return;
        }
        if (this.mGuildHashtagManage != null) {
            h();
        }
    }

    private final void c() {
        AIOParam aIOParam;
        if (this.mGuildHashtagManage == null && (aIOParam = this.mAIOParam) != null) {
            Intrinsics.checkNotNull(aIOParam);
            String g16 = com.tencent.guild.aio.util.a.g(aIOParam);
            AIOParam aIOParam2 = this.mAIOParam;
            Intrinsics.checkNotNull(aIOParam2);
            g gVar = new g(g16, com.tencent.guild.aio.util.a.b(aIOParam2), (Activity) this.mContext, 0);
            gVar.y(this.mCallback);
            gVar.w(new io0.a(gVar, (Activity) this.mContext, this.mEditText));
            this.mGuildHashtagManage = gVar;
        }
        GuildAIOInputEditText guildAIOInputEditText = this.mEditText;
        if (guildAIOInputEditText != null) {
            guildAIOInputEditText.setKeyEventPreImeListener("GuildHashtagHelper", new b());
        }
    }

    public final void b(@NotNull GuildAIOInputEditText editText, @NotNull ViewGroup inputContainer, @NotNull Context context, @NotNull AIOParam aioParam, @Nullable qp0.a callback) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(inputContainer, "inputContainer");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        this.mEditText = editText;
        this.mInputContainer = inputContainer;
        this.mContext = context;
        this.mAIOParam = aioParam;
        this.mCallback = callback;
    }

    public final boolean d() {
        g gVar = this.mGuildHashtagManage;
        if (gVar != null) {
            Intrinsics.checkNotNull(gVar);
            if (gVar.o()) {
                return true;
            }
        }
        return false;
    }

    public final void e() {
        GuildAIOInputEditText guildAIOInputEditText = this.mEditText;
        if (guildAIOInputEditText != null) {
            guildAIOInputEditText.setKeyEventPreImeListener("GuildHashtagHelper", null);
        }
        g gVar = this.mGuildHashtagManage;
        if (gVar != null) {
            gVar.q();
        }
        this.mGuildHashtagManage = null;
        this.mEditText = null;
        this.mInputContainer = null;
        this.mContext = null;
        this.mAIOParam = null;
    }

    public final void f(@NotNull CharSequence s16, int start, int before, int count) {
        Intrinsics.checkNotNullParameter(s16, "s");
        g gVar = this.mGuildHashtagManage;
        if (gVar != null) {
            Intrinsics.checkNotNull(gVar);
            if (gVar.p()) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuildHashtagHelper", 2, "guildHashtagPanel spanChange");
                    return;
                }
                return;
            }
        }
        a(s16, start, before, count);
    }

    public final void g(boolean isShow) {
        if (isShow) {
            c();
            g gVar = this.mGuildHashtagManage;
            if (gVar != null) {
                gVar.z(this.mInputContainer, "");
                return;
            }
            return;
        }
        g gVar2 = this.mGuildHashtagManage;
        if (gVar2 != null) {
            gVar2.dismissPanel();
        }
    }

    public final boolean h() {
        g gVar = this.mGuildHashtagManage;
        if (gVar != null) {
            Intrinsics.checkNotNull(gVar);
            return gVar.dismissPanel();
        }
        return false;
    }
}
