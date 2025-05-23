package com.tencent.mobileqq.aio.msglist.holder.component.markdown;

import androidx.lifecycle.LifecycleOwner;
import com.qq.e.comm.constants.Constants;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnView;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\f\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000fB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a;", "Lcom/tencent/qqnt/aio/holder/a;", "<init>", "()V", "a", "b", "c", "d", "e", "f", "g", tl.h.F, "i", "j", "k", "l", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$a;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$b;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$c;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$d;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$e;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$f;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$g;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$h;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$i;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$j;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$k;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$l;", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public abstract class a implements com.tencent.qqnt.aio.holder.a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$a;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "url", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.markdown.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final /* data */ class C7302a extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String url;

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.url;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof C7302a) && Intrinsics.areEqual(this.url, ((C7302a) other).url)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.url.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "ClickGenericUrl(url=" + this.url + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$b;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "url", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class b extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String url;

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.url;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof b) && Intrinsics.areEqual(this.url, ((b) other).url)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.url.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "ClickHttpUrl(url=" + this.url + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$c;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "localPath", "e", "getUrl", "url", "f", "a", Constants.KEYS.EXPOSED_CLICK_URL_KEY, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", tl.h.F, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "c", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class c extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String localPath;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String url;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String clickUrl;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AIOMsgItem msgItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull AIOMsgItem msgItem) {
            super(null);
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, str3, msgItem);
                return;
            }
            this.localPath = str;
            this.url = str2;
            this.clickUrl = str3;
            this.msgItem = msgItem;
        }

        @Nullable
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.clickUrl;
        }

        @Nullable
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.localPath;
        }

        @NotNull
        public final AIOMsgItem c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (AIOMsgItem) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.msgItem;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            if (Intrinsics.areEqual(this.localPath, cVar.localPath) && Intrinsics.areEqual(this.url, cVar.url) && Intrinsics.areEqual(this.clickUrl, cVar.clickUrl) && Intrinsics.areEqual(this.msgItem, cVar.msgItem)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            String str = this.localPath;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.url;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.clickUrl;
            if (str3 != null) {
                i3 = str3.hashCode();
            }
            return ((i17 + i3) * 31) + this.msgItem.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return "ClickImageSpan(localPath=" + this.localPath + ", url=" + this.url + ", clickUrl=" + this.clickUrl + ", msgItem=" + this.msgItem + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u000e\u0010!\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR'\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001f\u0010!\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u00128\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u000b\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$d;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/compat/b;", "d", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/compat/b;", "c", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/compat/b;", "ctx", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/utils/InlineBtnPayload;", "e", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "b", "()Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "btnView", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "f", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "a", "()Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btnModel", tl.h.F, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "payload", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/compat/b;Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class d extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b ctx;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final InlineBtnView<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> btnView;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final AIOMsgItem payload;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b ctx, @NotNull InlineBtnView<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> btnView, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, @Nullable AIOMsgItem aIOMsgItem) {
            super(null);
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            Intrinsics.checkNotNullParameter(btnView, "btnView");
            Intrinsics.checkNotNullParameter(btnModel, "btnModel");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ctx, btnView, btnModel, aIOMsgItem);
                return;
            }
            this.ctx = ctx;
            this.btnView = btnView;
            this.btnModel = btnModel;
            this.payload = aIOMsgItem;
        }

        @NotNull
        public final com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.btnModel;
        }

        @NotNull
        public final InlineBtnView<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (InlineBtnView) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.btnView;
        }

        @NotNull
        public final com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.ctx;
        }

        @Nullable
        public final AIOMsgItem d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (AIOMsgItem) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.payload;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof d)) {
                return false;
            }
            d dVar = (d) other;
            if (Intrinsics.areEqual(this.ctx, dVar.ctx) && Intrinsics.areEqual(this.btnView, dVar.btnView) && Intrinsics.areEqual(this.btnModel, dVar.btnModel) && Intrinsics.areEqual(this.payload, dVar.payload)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            int hashCode2 = ((((this.ctx.hashCode() * 31) + this.btnView.hashCode()) * 31) + this.btnModel.hashCode()) * 31;
            AIOMsgItem aIOMsgItem = this.payload;
            if (aIOMsgItem == null) {
                hashCode = 0;
            } else {
                hashCode = aIOMsgItem.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return "ClickInlineBtn(ctx=" + this.ctx + ", btnView=" + this.btnView + ", btnModel=" + this.btnModel + ", payload=" + this.payload + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$e;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a;", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "inlineCmdSchema", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "e", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "b", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class e extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String inlineCmdSchema;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AIOMsgItem msgItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull String inlineCmdSchema, @NotNull AIOMsgItem msgItem) {
            super(null);
            Intrinsics.checkNotNullParameter(inlineCmdSchema, "inlineCmdSchema");
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) inlineCmdSchema, (Object) msgItem);
            } else {
                this.inlineCmdSchema = inlineCmdSchema;
                this.msgItem = msgItem;
            }
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.inlineCmdSchema;
        }

        @NotNull
        public final AIOMsgItem b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AIOMsgItem) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.msgItem;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$f;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "url", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class f extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String url;

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.url;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof f) && Intrinsics.areEqual(this.url, ((f) other).url)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.url.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "ClickMqqApiUrl(url=" + this.url + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$g;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "businessId", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;", "e", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;", "c", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;", "msgItem", "Lcom/tencent/qqnt/aio/markdown/c;", "f", "Lcom/tencent/qqnt/aio/markdown/c;", "b", "()Lcom/tencent/qqnt/aio/markdown/c;", "listener", "<init>", "(ILcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;Lcom/tencent/qqnt/aio/markdown/c;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class g extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int businessId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MarkdownMsgItem msgItem;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.aio.markdown.c listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(int i3, @NotNull MarkdownMsgItem msgItem, @NotNull com.tencent.qqnt.aio.markdown.c listener) {
            super(null);
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            Intrinsics.checkNotNullParameter(listener, "listener");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), msgItem, listener);
                return;
            }
            this.businessId = i3;
            this.msgItem = msgItem;
            this.listener = listener;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.businessId;
        }

        @NotNull
        public final com.tencent.qqnt.aio.markdown.c b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.qqnt.aio.markdown.c) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.listener;
        }

        @NotNull
        public final MarkdownMsgItem c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MarkdownMsgItem) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.msgItem;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof g)) {
                return false;
            }
            g gVar = (g) other;
            if (this.businessId == gVar.businessId && Intrinsics.areEqual(this.msgItem, gVar.msgItem) && Intrinsics.areEqual(this.listener, gVar.listener)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((this.businessId * 31) + this.msgItem.hashCode()) * 31) + this.listener.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "DispatchOnBindIntent(businessId=" + this.businessId + ", msgItem=" + this.msgItem + ", listener=" + this.listener + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$h;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/aio/markdown/c;", "d", "Lcom/tencent/qqnt/aio/markdown/c;", "a", "()Lcom/tencent/qqnt/aio/markdown/c;", "listener", "<init>", "(Lcom/tencent/qqnt/aio/markdown/c;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class h extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.aio.markdown.c listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(@NotNull com.tencent.qqnt.aio.markdown.c listener) {
            super(null);
            Intrinsics.checkNotNullParameter(listener, "listener");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) listener);
            } else {
                this.listener = listener;
            }
        }

        @NotNull
        public final com.tencent.qqnt.aio.markdown.c a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.qqnt.aio.markdown.c) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.listener;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof h) && Intrinsics.areEqual(this.listener, ((h) other).listener)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.listener.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "DispatchOnRemoveIntent(listener=" + this.listener + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0012\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$i;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroidx/lifecycle/LifecycleOwner;", "d", "Landroidx/lifecycle/LifecycleOwner;", "a", "()Landroidx/lifecycle/LifecycleOwner;", "b", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "<init>", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class i extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private LifecycleOwner lifecycleOwner;

        public i(@Nullable LifecycleOwner lifecycleOwner) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) lifecycleOwner);
            } else {
                this.lifecycleOwner = lifecycleOwner;
            }
        }

        @Nullable
        public final LifecycleOwner a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LifecycleOwner) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.lifecycleOwner;
        }

        public final void b(@Nullable LifecycleOwner lifecycleOwner) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) lifecycleOwner);
            } else {
                this.lifecycleOwner = lifecycleOwner;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof i) && Intrinsics.areEqual(this.lifecycleOwner, ((i) other).lifecycleOwner)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            LifecycleOwner lifecycleOwner = this.lifecycleOwner;
            if (lifecycleOwner == null) {
                return 0;
            }
            return lifecycleOwner.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return "GetLifeCycleOwner(lifecycleOwner=" + this.lifecycleOwner + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u00a2\u0006\u0004\b\u0011\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$j;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "b", "(Z)V", "filiter", "<init>", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class j extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean filiter;

        public j() {
            this(false, 1, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                return;
            }
            iPatchRedirector.redirect((short) 10, (Object) this);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.filiter;
        }

        public final void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            } else {
                this.filiter = z16;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof j) && this.filiter == ((j) other).filiter) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            boolean z16 = this.filiter;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "IsFiliterAIO(filiter=" + this.filiter + ")";
        }

        public j(boolean z16) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.filiter = z16;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
            }
        }

        public /* synthetic */ j(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u00a2\u0006\u0004\b\u0011\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$k;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "getShow", "()Z", "a", "(Z)V", "show", "<init>", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class k extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean show;

        public k() {
            this(false, 1, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                return;
            }
            iPatchRedirector.redirect((short) 10, (Object) this);
        }

        public final void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            } else {
                this.show = z16;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof k) && this.show == ((k) other).show) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            boolean z16 = this.show;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "ShowCustomNode(show=" + this.show + ")";
        }

        public k(boolean z16) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.show = z16;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
            }
        }

        public /* synthetic */ k(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? true : z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$l;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "d", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "a", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "e", "Z", "b", "()Z", "isRunning", "<init>", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Z)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class l extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AIOMsgItem msgItem;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isRunning;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(@NotNull AIOMsgItem msgItem, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, msgItem, Boolean.valueOf(z16));
            } else {
                this.msgItem = msgItem;
                this.isRunning = z16;
            }
        }

        @NotNull
        public final AIOMsgItem a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AIOMsgItem) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.msgItem;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.isRunning;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof l)) {
                return false;
            }
            l lVar = (l) other;
            if (Intrinsics.areEqual(this.msgItem, lVar.msgItem) && this.isRunning == lVar.isRunning) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            int hashCode = this.msgItem.hashCode() * 31;
            boolean z16 = this.isRunning;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "UpdateAnimStatus(msgItem=" + this.msgItem + ", isRunning=" + this.isRunning + ")";
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
