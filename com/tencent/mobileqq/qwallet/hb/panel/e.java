package com.tencent.mobileqq.qwallet.hb.panel;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.a;
import com.tencent.mobileqq.utils.QQTheme;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00112\u00020\u0001:\u0005\u0004\u0012\u0011\u0013\u0014B\t\b\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010R(\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000b\u0082\u0001\u0004\u0015\u0016\u0017\u0018\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/e;", "Lcom/tencent/mobileqq/qwallet/a;", "", "<set-?>", "a", "Ljava/lang/Object;", "getChatPieProxy", "()Ljava/lang/Object;", "chatPieProxy", "", "j", "()I", "qqTheme", "i", "guildTheme", "<init>", "()V", "b", "c", "d", "e", "Lcom/tencent/mobileqq/qwallet/hb/panel/e$c;", "Lcom/tencent/mobileqq/qwallet/hb/panel/e$b;", "Lcom/tencent/mobileqq/qwallet/hb/panel/e$d;", "Lcom/tencent/mobileqq/qwallet/hb/panel/e$e;", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public abstract class e implements com.tencent.mobileqq.qwallet.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Object chatPieProxy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/e$a;", "", "", "isGuild", "chatPieProxy", "Lcom/tencent/mobileqq/qwallet/a;", "a", "", "chatType", "b", "AIO_SCENE_MASK_GUILD", "I", "AIO_SCENE_MASK_QQ", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.hb.panel.e$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final com.tencent.mobileqq.qwallet.a a(boolean isGuild, @Nullable Object chatPieProxy) {
            d4.d dVar;
            e c8463e;
            if (isGuild) {
                if (chatPieProxy == null) {
                    c8463e = new b();
                } else {
                    c8463e = new c();
                }
            } else {
                if (chatPieProxy instanceof d4.d) {
                    dVar = (d4.d) chatPieProxy;
                } else {
                    dVar = null;
                }
                boolean z16 = false;
                if (dVar != null && dVar.a()) {
                    z16 = true;
                }
                if (z16) {
                    c8463e = new d();
                } else {
                    c8463e = new C8463e();
                }
            }
            c8463e.chatPieProxy = chatPieProxy;
            return c8463e;
        }

        @JvmStatic
        @NotNull
        public final com.tencent.mobileqq.qwallet.a b(int chatType) {
            if (chatType == 1) {
                return new d();
            }
            return new C8463e();
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/e$b;", "Lcom/tencent/mobileqq/qwallet/hb/panel/e;", "", "a", "", "d", "b", "f", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends e {
        public b() {
            super(null);
        }

        @Override // com.tencent.mobileqq.qwallet.a
        public int a() {
            return i();
        }

        @Override // com.tencent.mobileqq.qwallet.hb.panel.e, com.tencent.mobileqq.qwallet.a
        public boolean b() {
            return false;
        }

        @Override // com.tencent.mobileqq.qwallet.a
        public boolean d() {
            return true;
        }

        @Override // com.tencent.mobileqq.qwallet.a
        public int f() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/e$c;", "Lcom/tencent/mobileqq/qwallet/hb/panel/e;", "", "a", "", "d", "b", "f", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c extends e {
        public c() {
            super(null);
        }

        @Override // com.tencent.mobileqq.qwallet.a
        public int a() {
            return i();
        }

        @Override // com.tencent.mobileqq.qwallet.hb.panel.e, com.tencent.mobileqq.qwallet.a
        public boolean b() {
            return false;
        }

        @Override // com.tencent.mobileqq.qwallet.a
        public boolean d() {
            return true;
        }

        @Override // com.tencent.mobileqq.qwallet.a
        public int f() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/e$d;", "Lcom/tencent/mobileqq/qwallet/hb/panel/e;", "", "a", "", "d", "f", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d extends e {
        public d() {
            super(null);
        }

        @Override // com.tencent.mobileqq.qwallet.a
        public int a() {
            return j();
        }

        @Override // com.tencent.mobileqq.qwallet.a
        public boolean d() {
            return true;
        }

        @Override // com.tencent.mobileqq.qwallet.a
        public int f() {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/e$e;", "Lcom/tencent/mobileqq/qwallet/hb/panel/e;", "", "a", "", "d", "c", "f", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.hb.panel.e$e, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C8463e extends e {
        public C8463e() {
            super(null);
        }

        @Override // com.tencent.mobileqq.qwallet.a
        public int a() {
            return j();
        }

        @Override // com.tencent.mobileqq.qwallet.hb.panel.e, com.tencent.mobileqq.qwallet.a
        public boolean c() {
            return true;
        }

        @Override // com.tencent.mobileqq.qwallet.a
        public boolean d() {
            return true;
        }

        @Override // com.tencent.mobileqq.qwallet.a
        public int f() {
            return 1;
        }
    }

    public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @NotNull
    public static final com.tencent.mobileqq.qwallet.a h(boolean z16, @Nullable Object obj) {
        return INSTANCE.a(z16, obj);
    }

    @Override // com.tencent.mobileqq.qwallet.a
    public boolean b() {
        return a.C8452a.c(this);
    }

    @Override // com.tencent.mobileqq.qwallet.a
    public boolean c() {
        return a.C8452a.b(this);
    }

    @Override // com.tencent.mobileqq.qwallet.a
    public boolean e() {
        return a.C8452a.a(this);
    }

    protected final int i() {
        if (QQTheme.isNowThemeIsNight()) {
            return R.style.a7h;
        }
        return R.style.a7f;
    }

    protected final int j() {
        if (QQTheme.isNowThemeIsNight()) {
            return R.style.a7g;
        }
        return R.style.a7e;
    }

    e() {
    }
}
