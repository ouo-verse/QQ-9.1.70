package com.tencent.biz.qui.noticebar;

import android.view.View;
import androidx.annotation.StringRes;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J#\u0010\u0007\u001a\u00028\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&\u00a2\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00028\u00002\b\b\u0001\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/qui/noticebar/a;", "T", "Lcom/tencent/biz/qui/noticebar/b;", "", "msg", "Landroid/view/View$OnClickListener;", "onClickListener", "b", "(Ljava/lang/String;Landroid/view/View$OnClickListener;)Ljava/lang/Object;", "", "msgRes", "f", "(ILandroid/view/View$OnClickListener;)Ljava/lang/Object;", "QUINoticeBar_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public interface a<T> extends b<T> {
    T b(@Nullable String msg2, @Nullable View.OnClickListener onClickListener);

    T f(@StringRes int msgRes, @Nullable View.OnClickListener onClickListener);
}
