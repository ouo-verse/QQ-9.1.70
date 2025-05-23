package com.tencent.mobileqq.gamecenter.qa.aio.input;

import android.widget.EditText;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/input/p;", "Lcom/tencent/mvi/api/ability/d;", "<init>", "()V", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class p implements com.tencent.mvi.api.ability.d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\t\u0010\u0007R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/input/p$a;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/p;", "Landroid/widget/EditText;", "a", "Landroid/widget/EditText;", "()Landroid/widget/EditText;", "b", "(Landroid/widget/EditText;)V", "editText", "<init>", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends p {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private EditText editText;

        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final EditText getEditText() {
            return this.editText;
        }

        public final void b(@Nullable EditText editText) {
            this.editText = editText;
        }

        public a(@Nullable EditText editText) {
            this.editText = editText;
        }

        public /* synthetic */ a(EditText editText, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : editText);
        }
    }
}
