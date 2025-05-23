package com.tencent.guild.aio.msglist.markdown.innerkeyboard;

import android.text.TextUtils;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.InlineBtnClickDispatcher;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnView;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqnt.markdown.api.IMarkdownConfigApi;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J$\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0007j\u0002`\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0007j\u0002`\bH\u0002J(\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J@\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00022\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0011\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/guild/aio/msglist/markdown/innerkeyboard/e;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/InlineBtnClickDispatcher;", "Lcom/tencent/guild/aio/msglist/markdown/inlineboard/a;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "Lcom/tencent/guild/aio/msglist/markdown/InlineBtnPayload;", "", "actionType", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;", "Lcom/tencent/guild/aio/msglist/markdown/IGuildInlineKeyboardClickHandler;", h.F, "i", "c", "ctx", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "btnView", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btnModel", "payload", "", "j", "<init>", "()V", "f", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e extends InlineBtnClickDispatcher<com.tencent.guild.aio.msglist.markdown.inlineboard.a, GuildMsgItem> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<String, WeakReference<InlineBtnView<com.tencent.guild.aio.msglist.markdown.inlineboard.a, GuildMsgItem>>> f111781g = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R=\u0010\n\u001a(\u0012\u0004\u0012\u00020\u0003\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0005j\u0002`\t0\u00040\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/msglist/markdown/innerkeyboard/e$a;", "", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "Lcom/tencent/guild/aio/msglist/markdown/inlineboard/a;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "Lcom/tencent/guild/aio/msglist/markdown/InlineBtnPayload;", "Lcom/tencent/guild/aio/msglist/markdown/InlineBtnView;", "loadingBtn", "Ljava/util/concurrent/ConcurrentHashMap;", "a", "()Ljava/util/concurrent/ConcurrentHashMap;", "UNSUPPORTED_TIPS", "Ljava/lang/String;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.markdown.innerkeyboard.e$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ConcurrentHashMap<String, WeakReference<InlineBtnView<com.tencent.guild.aio.msglist.markdown.inlineboard.a, GuildMsgItem>>> a() {
            return e.f111781g;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001j\u0002`\u0005JD\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00022\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0007j\u0002`\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\f\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/guild/aio/msglist/markdown/innerkeyboard/e$b", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;", "Lcom/tencent/guild/aio/msglist/markdown/inlineboard/a;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "Lcom/tencent/guild/aio/msglist/markdown/InlineBtnPayload;", "Lcom/tencent/guild/aio/msglist/markdown/IGuildInlineKeyboardClickHandler;", "ctx", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "Lcom/tencent/guild/aio/msglist/markdown/InlineBtnView;", "btnView", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btnModel", "payload", "", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<com.tencent.guild.aio.msglist.markdown.inlineboard.a, GuildMsgItem> {
        b() {
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull com.tencent.guild.aio.msglist.markdown.inlineboard.a ctx, @NotNull InlineBtnView<com.tencent.guild.aio.msglist.markdown.inlineboard.a, GuildMsgItem> btnView, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, @Nullable GuildMsgItem payload) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            Intrinsics.checkNotNullParameter(btnView, "btnView");
            Intrinsics.checkNotNullParameter(btnModel, "btnModel");
            String d16 = btnModel.a().d();
            if (!(!TextUtils.isEmpty(d16))) {
                d16 = null;
            }
            if (d16 == null) {
                d16 = "\u6682\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u6309\u94ae\uff0c\u8bf7\u5347\u7ea7\u5ba2\u6237\u7aef";
            }
            QQToast.makeText(ctx.getContext(), d16, 0).show();
        }
    }

    public e() {
        super(new g());
    }

    private final com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<com.tencent.guild.aio.msglist.markdown.inlineboard.a, GuildMsgItem> h(int actionType) {
        com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<com.tencent.guild.aio.msglist.markdown.inlineboard.a, GuildMsgItem> cVar;
        if (actionType != 0) {
            if (actionType != 1) {
                if (actionType != 2) {
                    if (actionType != 3) {
                        cVar = i();
                    } else {
                        cVar = (com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b) ((IMarkdownConfigApi) QRoute.api(IMarkdownConfigApi.class)).getWhitelistedSchemeClickListener(new d());
                    }
                } else {
                    cVar = new a();
                }
            } else {
                cVar = new BtnCallBackHandler();
            }
        } else {
            cVar = new c();
        }
        b().put(Integer.valueOf(actionType), cVar);
        return cVar;
    }

    private final com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<com.tencent.guild.aio.msglist.markdown.inlineboard.a, GuildMsgItem> i() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.InlineBtnClickDispatcher
    @Nullable
    public com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<com.tencent.guild.aio.msglist.markdown.inlineboard.a, GuildMsgItem> c(int actionType) {
        if (b().containsKey(Integer.valueOf(actionType))) {
            return b().get(Integer.valueOf(actionType));
        }
        return h(actionType);
    }

    @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.InlineBtnClickDispatcher, com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull com.tencent.guild.aio.msglist.markdown.inlineboard.a ctx, @NotNull InlineBtnView<com.tencent.guild.aio.msglist.markdown.inlineboard.a, GuildMsgItem> btnView, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, @Nullable GuildMsgItem payload) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(btnView, "btnView");
        Intrinsics.checkNotNullParameter(btnModel, "btnModel");
        super.a(ctx, btnView, btnModel, payload);
        fq0.b.f400314a.h(btnView, btnModel);
    }
}
