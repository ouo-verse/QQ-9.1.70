package com.tencent.biz.qui.noticebar;

import android.view.View;
import androidx.annotation.StringRes;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J#\u0010\u0006\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00028\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00028\u00002\b\b\u0001\u0010\r\u001a\u00020\fH&\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00028\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00028\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&\u00a2\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0015H&\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001a\u00020\fH&J\b\u0010\u001b\u001a\u00020\u001aH&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/biz/qui/noticebar/b;", "T", "", "", "sizeDp", "startDp", "a", "(FF)Ljava/lang/Object;", "", "msg", "setMsg", "(Ljava/lang/String;)Ljava/lang/Object;", "", "msgId", "e", "(I)Ljava/lang/Object;", "Landroid/view/View$OnClickListener;", "clickListener", "c", "(Landroid/view/View$OnClickListener;)Ljava/lang/Object;", "k", "", OpenHippyInfo.EXTRA_KEY_IS_TRANSPARENT, "g", "(Z)Ljava/lang/Object;", "j", "Landroid/view/View;", "getView", "QUINoticeBar_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public interface b<T> {
    T a(float sizeDp, float startDp);

    T c(@Nullable View.OnClickListener clickListener);

    T e(@StringRes int msgId);

    T g(boolean isTransparent);

    @NotNull
    View getView();

    int j();

    T k(@Nullable View.OnClickListener clickListener);

    T setMsg(@Nullable String msg2);
}
