package com.tencent.qqnt.aio.api.impl;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.emotion.info.SystemAndEmojiEmotionInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Landroid/view/View;", "index", "", "emotionInfo", "Lcom/tencent/qqnt/emotion/info/SystemAndEmojiEmotionInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class EmotionMenusCreator$getEmotionMenuItems$1 extends Lambda implements Function2<Integer, SystemAndEmojiEmotionInfo, View> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ EmotionMenusCreator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionMenusCreator$getEmotionMenuItems$1(EmotionMenusCreator emotionMenusCreator) {
        super(2);
        this.this$0 = emotionMenusCreator;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) emotionMenusCreator);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EmotionMenusCreator this$0, ImageView imageView, SystemAndEmojiEmotionInfo emotionInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(imageView, "$imageView");
        Intrinsics.checkNotNullParameter(emotionInfo, "$emotionInfo");
        this$0.h(imageView, emotionInfo);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ View invoke(Integer num, SystemAndEmojiEmotionInfo systemAndEmojiEmotionInfo) {
        return invoke(num.intValue(), systemAndEmojiEmotionInfo);
    }

    @Nullable
    public final View invoke(int i3, @NotNull final SystemAndEmojiEmotionInfo emotionInfo) {
        final ImageView k3;
        View s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) emotionInfo);
        }
        Intrinsics.checkNotNullParameter(emotionInfo, "emotionInfo");
        Drawable a16 = emotionInfo.a();
        if (a16 == null) {
            return null;
        }
        final EmotionMenusCreator emotionMenusCreator = this.this$0;
        k3 = emotionMenusCreator.k();
        k3.setImageDrawable(a16);
        String c16 = com.tencent.qqnt.emotion.data.b.INSTANCE.c(emotionInfo);
        String qqStr = HardCodeUtil.qqStr(R.string.zug);
        if (TextUtils.isEmpty(c16)) {
            c16 = HardCodeUtil.qqStr(R.string.f170197yp0);
        }
        k3.setFocusable(true);
        k3.setImportantForAccessibility(1);
        AccessibilityUtil.p(k3, qqStr + c16);
        s16 = emotionMenusCreator.s(k3, i3, new View.OnClickListener() { // from class: com.tencent.qqnt.aio.api.impl.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmotionMenusCreator$getEmotionMenuItems$1.b(EmotionMenusCreator.this, k3, emotionInfo, view);
            }
        });
        return s16;
    }
}
