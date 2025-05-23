package com.tencent.android.androidbypass.richui.view;

import android.view.View;
import androidx.annotation.FloatRange;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/android/androidbypass/richui/view/d;", "Lcom/tencent/android/androidbypass/richui/view/h;", "Landroid/view/View;", "", "progress", "", HippyQQPagView.FunctionName.SET_PROGRESS, "", "state", "a", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public interface d extends h<View> {
    void a(@NotNull String state);

    void setProgress(@FloatRange(from = 0.0d, to = 1.0d) double progress);
}
