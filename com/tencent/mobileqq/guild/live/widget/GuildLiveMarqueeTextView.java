package com.tencent.mobileqq.guild.live.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.mobileqq.guild.util.WeakObjectRunnable;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildLiveMarqueeTextView extends AppCompatTextView {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.live.widget.GuildLiveMarqueeTextView$1, reason: invalid class name */
    /* loaded from: classes14.dex */
    class AnonymousClass1 extends WeakObjectRunnable<View> {
        final /* synthetic */ GuildLiveMarqueeTextView this$0;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.guild.util.WeakObjectRunnable
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NonNull View view) {
            view.setSelected(true);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.live.widget.GuildLiveMarqueeTextView$2, reason: invalid class name */
    /* loaded from: classes14.dex */
    class AnonymousClass2 extends WeakObjectRunnable<View> {
        final /* synthetic */ GuildLiveMarqueeTextView this$0;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.guild.util.WeakObjectRunnable
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NonNull View view) {
            view.setSelected(false);
        }
    }

    public GuildLiveMarqueeTextView(Context context) {
        super(context);
    }

    public GuildLiveMarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GuildLiveMarqueeTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
