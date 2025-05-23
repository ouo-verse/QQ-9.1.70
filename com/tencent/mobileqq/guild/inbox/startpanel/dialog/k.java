package com.tencent.mobileqq.guild.inbox.startpanel.dialog;

import androidx.fragment.app.DialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/k;", "", "", "type", "Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/InboxNodeSettingBaseDialog;", "a", "Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/d;", "Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/d;", "callback", "<init>", "(Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/d;)V", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class k {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/k$a;", "", "", "type", "Landroidx/fragment/app/DialogFragment;", "a", "TYPE_C2C_NODE", "I", "TYPE_FEED_NODE", "TYPE_NOTICE_FRAGMENT", "TYPE_NOTICE_NODE", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.inbox.startpanel.dialog.k$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DialogFragment a(int type) {
            return new InboxThirdPageNotifySettingDialog(type);
        }

        Companion() {
        }
    }

    public k(@NotNull d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    @NotNull
    public final InboxNodeSettingBaseDialog a(int type) {
        if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    if (type == 4) {
                        return new InboxNoticeNodeSettingDialog(this.callback, false);
                    }
                    throw new IllegalArgumentException("Unknown viewType=" + type + "!");
                }
                return new InboxFeedNodeSettingDialog(this.callback, "pg_sgrp_mine", false, 4, null);
            }
            return new InboxNoticeNodeSettingDialog(this.callback, true);
        }
        return new InboxC2CNodeSettingDialog(this.callback);
    }
}
