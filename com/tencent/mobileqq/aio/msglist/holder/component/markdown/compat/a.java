package com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat;

import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnView;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0002\b\u0003\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002H&J \u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H&J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006H&J\u001c\u0010\u0010\u001a\u00020\u000f2\n\u0010\f\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u000e\u001a\u00020\rH&J\u001c\u0010\u0011\u001a\u00020\t2\n\u0010\f\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u000e\u001a\u00020\rH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/compat/a;", "", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/utils/InlineBtnPayload;", "btnView", "", "a", "btnKey", "", "b", "c", "payload", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btnModel", "", "e", "d", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface a {
    @NotNull
    String a(@NotNull InlineBtnView<?, AIOMsgItem> btnView);

    void b(@NotNull String btnKey, @NotNull InlineBtnView<?, ?> btnView);

    void c(@NotNull String btnKey);

    void d(@NotNull AIOMsgItem payload, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel);

    boolean e(@NotNull AIOMsgItem payload, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel);
}
