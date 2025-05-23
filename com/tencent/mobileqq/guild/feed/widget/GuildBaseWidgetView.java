package com.tencent.mobileqq.guild.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.widget.BaseWidgetView;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildBaseWidgetView<T> extends BaseWidgetView<T> {
    public GuildBaseWidgetView(@NonNull Context context) {
        super(context);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    public GuildBaseWidgetView(@NonNull Context context, Integer num) {
        super(context, num);
    }

    public GuildBaseWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GuildBaseWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public GuildBaseWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(T t16, int i3) {
    }
}
