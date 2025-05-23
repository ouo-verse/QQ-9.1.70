package com.tencent.mobileqq.zootopia.api;

import android.content.DialogInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JX\u0010\u000f\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zootopia/api/f;", "", "", "title", "", "content", "leftBtnText", "rightBtnText", "Landroid/content/DialogInterface$OnClickListener;", "onConfirm", "onCancel", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "", "onDialogCreateCallback", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface f {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        public static /* synthetic */ void a(f fVar, String str, CharSequence charSequence, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, Function1 function1, int i3, Object obj) {
            Function1 function12;
            if (obj == null) {
                if ((i3 & 64) != 0) {
                    function12 = null;
                } else {
                    function12 = function1;
                }
                fVar.a(str, charSequence, str2, str3, onClickListener, onClickListener2, function12);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showCommonDialog");
        }
    }

    void a(@Nullable String title, @NotNull CharSequence content, @NotNull String leftBtnText, @NotNull String rightBtnText, @Nullable DialogInterface.OnClickListener onConfirm, @Nullable DialogInterface.OnClickListener onCancel, @Nullable Function1<? super QQCustomDialog, Unit> onDialogCreateCallback);
}
