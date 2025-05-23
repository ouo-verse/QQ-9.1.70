package com.tencent.mobileqq.guild.feed.nativepublish.edittext;

import android.text.Editable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0001\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/e;", "Lcom/tencent/mvi/api/ability/d;", "Lcom/tencent/base/api/ability/VBStateCmd;", "<init>", "()V", "a", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/e$a;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class e implements com.tencent.mvi.api.ability.d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/e$a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/e;", "Landroid/text/Editable;", "a", "Landroid/text/Editable;", "()Landroid/text/Editable;", "b", "(Landroid/text/Editable;)V", "editableText", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends e {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Editable editableText;

        public a() {
            super(null);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Editable getEditableText() {
            return this.editableText;
        }

        public final void b(@Nullable Editable editable) {
            this.editableText = editable;
        }
    }

    public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    e() {
    }
}
