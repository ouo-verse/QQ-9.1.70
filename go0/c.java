package go0;

import android.content.Context;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.ViewGroup;
import android.widget.EditText;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.guild.aio.activity.GuildChatFragmentHiddenChangedEvent;
import com.tencent.guild.aio.input.at.utils.AtTroopMemberSpan;
import com.tencent.guild.aio.input.widget.GuildAIOInputEditText;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.api.IHashTagSearchLinkApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.search.api.IAIOHashTagSearchLinkApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b5\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001N\u0018\u0000 T2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001UB\u0007\u00a2\u0006\u0004\bR\u0010SJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002J$\u0010\u000f\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J>\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u0006\u0010\u001d\u001a\u00020\tJ\u000e\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020\tJ\u0012\u0010$\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J$\u0010(\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020&0%j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020&`'H\u0016J\u0006\u0010)\u001a\u00020\tJ\u0006\u0010*\u001a\u00020\tJ\u000e\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u001eR\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u00105R\u0014\u00109\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010@\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010I\u001a\u00020\u001e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bH\u0010FR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006V"}, d2 = {"Lgo0/c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/guild/aio/activity/GuildChatFragmentHiddenChangedEvent;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "before", "count", "", "e", "Landroid/text/Spanned;", "spannedText", "charSequence", "end", "f", "Lcom/tencent/guild/aio/input/widget/GuildAIOInputEditText;", "editText", "Landroid/view/ViewGroup;", "inputContainer", "Landroid/content/Context;", "context", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "Lqp0/a;", "callback", "Lcom/tencent/aio/api/runtime/a;", "aioContext", tl.h.F, DomainData.DOMAIN_NAME, "", "isEnable", "l", "g", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "j", "k", ViewStickEventHelper.IS_SHOW, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/data/AIOContact;", "d", "Lcom/tencent/aio/data/AIOContact;", "mAIOContact", "Lro0/b;", "Lro0/b;", "guildAtHelper", "Ljo0/a;", "Ljo0/a;", "guildHashTagHelper", "Lap0/b;", "Lap0/b;", "robotSlashHelper", "Lzo0/a;", "i", "Lzo0/a;", "robotAtHelper", "Lap0/e;", "Lap0/e;", "plusPanelDataHelper", "Lcom/tencent/qqnt/search/api/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/search/api/a;", "quickSearchHelper", "D", "Z", "mTextWatcherEnabled", "E", "mSlashEnabled", "Landroid/widget/EditText;", UserInfo.SEX_FEMALE, "Landroid/widget/EditText;", "mEditText", "go0/c$b", "G", "Lgo0/c$b;", "mTextWatcher", "<init>", "()V", "H", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c implements SimpleEventReceiver<GuildChatFragmentHiddenChangedEvent> {

    @NotNull
    private static final List<Class<?>> I;

    /* renamed from: F, reason: from kotlin metadata */
    private EditText mEditText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOContact mAIOContact;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ro0.b guildAtHelper = new ro0.b();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final jo0.a guildHashTagHelper = new jo0.a();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ap0.b robotSlashHelper = new ap0.b();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final zo0.a robotAtHelper = new zo0.a();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ap0.e plusPanelDataHelper = new ap0.e();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.search.api.a quickSearchHelper = IAIOHashTagSearchLinkApi.f362083g.newInputHelper();

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mTextWatcherEnabled = true;

    /* renamed from: E, reason: from kotlin metadata */
    private final boolean mSlashEnabled = true;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final b mTextWatcher = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"go0/c$b", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            if (c.this.mTextWatcherEnabled) {
                c.this.guildAtHelper.a();
                if (s16 != null) {
                    c.this.quickSearchHelper.a(s16);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence s16, int start, int count, int after) {
            Intrinsics.checkNotNullParameter(s16, "s");
            if (c.this.mTextWatcherEnabled) {
                c.this.guildAtHelper.b(s16, start, count, after);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@NotNull CharSequence s16, int start, int before, int count) {
            Intrinsics.checkNotNullParameter(s16, "s");
            if (c.this.mTextWatcherEnabled) {
                c.this.e(s16, start, before, count);
            }
        }
    }

    static {
        List<Class<?>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(AtTroopMemberSpan.class);
        I = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(CharSequence s16, int start, int before, int count) {
        if (this.guildAtHelper.e()) {
            this.guildAtHelper.g(s16, start, before, count);
            return;
        }
        if (this.guildHashTagHelper.d()) {
            this.guildHashTagHelper.f(s16, start, before, count);
            return;
        }
        if (this.robotSlashHelper.e()) {
            this.robotSlashHelper.h(s16, start, before, count);
            return;
        }
        EditText editText = this.mEditText;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        Editable editableText = editText.getEditableText();
        EditText editText3 = this.mEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            editText2 = editText3;
        }
        int f16 = f(editableText, s16, editText2.getSelectionStart());
        if (f16 != 1) {
            if (f16 != 2) {
                if (f16 == 3) {
                    this.robotSlashHelper.h(s16, start, before, count);
                    return;
                }
                return;
            }
            this.guildHashTagHelper.f(s16, start, before, count);
            return;
        }
        this.guildAtHelper.g(s16, start, before, count);
    }

    private final int f(Spanned spannedText, CharSequence charSequence, int end) {
        boolean z16;
        int lastIndexOf$default;
        boolean startsWith$default;
        int i3 = 0;
        if (charSequence != null && charSequence.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || spannedText == null || end < 1) {
            return -1;
        }
        int length = charSequence.length();
        if (end > length) {
            end = length;
        }
        if (this.mSlashEnabled) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(spannedText.toString(), "/", false, 2, null);
            if (startsWith$default) {
                return 3;
            }
        }
        int[] iArr = {64, 42, 65312, 65290};
        int i16 = end - 1;
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) spannedText, '\n', i16, false, 4, (Object) null);
        int i17 = -1;
        while (true) {
            if (i3 < 4) {
                int f16 = ko0.a.f(spannedText, iArr[i3], lastIndexOf$default + 1, end);
                if (f16 > lastIndexOf$default) {
                    i17 = i3;
                    lastIndexOf$default = f16;
                }
                if (lastIndexOf$default == i16) {
                    break;
                }
                i3++;
            } else {
                i3 = i17;
                break;
            }
        }
        if (i3 >= 0) {
            int i18 = i3 % 4;
            if (i18 == 1) {
                return 2;
            }
            if (i18 == 0) {
                return 1;
            }
        }
        return -1;
    }

    public static /* synthetic */ void i(c cVar, GuildAIOInputEditText guildAIOInputEditText, ViewGroup viewGroup, Context context, AIOParam aIOParam, qp0.a aVar, com.tencent.aio.api.runtime.a aVar2, int i3, Object obj) {
        qp0.a aVar3;
        com.tencent.aio.api.runtime.a aVar4;
        if ((i3 & 16) != 0) {
            aVar3 = null;
        } else {
            aVar3 = aVar;
        }
        if ((i3 & 32) != 0) {
            aVar4 = null;
        } else {
            aVar4 = aVar2;
        }
        cVar.h(guildAIOInputEditText, viewGroup, context, aIOParam, aVar3, aVar4);
    }

    public final void g() {
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        if (simpleEventBus != null) {
            simpleEventBus.unRegisterReceiver(this);
        }
        EditText editText = this.mEditText;
        if (editText != null) {
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                editText = null;
            }
            editText.removeTextChangedListener(this.mTextWatcher);
        }
        this.guildAtHelper.f();
        this.guildHashTagHelper.e();
        this.robotSlashHelper.g();
        this.robotAtHelper.i();
        this.plusPanelDataHelper.i();
        this.quickSearchHelper.onDestroy();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<GuildChatFragmentHiddenChangedEvent>> getEventClass() {
        ArrayList<Class<GuildChatFragmentHiddenChangedEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildChatFragmentHiddenChangedEvent.class);
        return arrayListOf;
    }

    public final void h(@NotNull GuildAIOInputEditText editText, @NotNull ViewGroup inputContainer, @NotNull Context context, @NotNull AIOParam aioParam, @Nullable qp0.a callback, @Nullable com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(inputContainer, "inputContainer");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        this.mEditText = editText;
        this.guildAtHelper.d(editText, inputContainer, context, aioParam);
        this.guildHashTagHelper.b(editText, inputContainer, context, aioParam, callback);
        this.robotSlashHelper.d(inputContainer, aioParam, false, aioContext);
        this.robotAtHelper.g(editText, inputContainer, context, aioParam, aioContext);
        this.plusPanelDataHelper.h(aioParam);
        this.quickSearchHelper.b(I, editText);
        this.quickSearchHelper.setEnabled(IHashTagSearchLinkApi.f282735g.switchOn(Util.toLongOrDefault(com.tencent.guild.aio.util.a.b(aioParam), 0L), com.tencent.guild.aio.util.a.e(aioParam)));
        editText.addTextChangedListener(this.mTextWatcher);
        this.mAIOContact = aioParam.r().c();
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        if (simpleEventBus != null) {
            simpleEventBus.registerReceiver(this);
        }
    }

    public final void j() {
        this.robotAtHelper.h();
    }

    public final void k() {
        this.robotAtHelper.j();
        EditText editText = this.mEditText;
        if (editText != null) {
            com.tencent.qqnt.search.api.a aVar = this.quickSearchHelper;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                editText = null;
            }
            Editable text = editText.getText();
            Intrinsics.checkNotNullExpressionValue(text, "mEditText.text");
            aVar.a(text);
            return;
        }
        QLog.i("GuildAtCluster", 1, "[onInputDraftRecovered] mEditText is uninitialized!");
    }

    public final void l(boolean isEnable) {
        this.mTextWatcherEnabled = isEnable;
    }

    public final void m(boolean isShow) {
        this.guildHashTagHelper.g(isShow);
    }

    public final void n() {
        this.guildAtHelper.h();
        this.guildHashTagHelper.h();
        this.robotSlashHelper.b();
        this.robotAtHelper.e();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (!(event instanceof GuildChatFragmentHiddenChangedEvent)) {
            return;
        }
        GuildChatFragmentHiddenChangedEvent guildChatFragmentHiddenChangedEvent = (GuildChatFragmentHiddenChangedEvent) event;
        if (guildChatFragmentHiddenChangedEvent.getHidden() && Intrinsics.areEqual(guildChatFragmentHiddenChangedEvent.getAioContact(), this.mAIOContact)) {
            n();
        }
    }
}
