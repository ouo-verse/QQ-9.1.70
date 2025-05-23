package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qcircleshadow.lib.variation.HostEmotionUtil;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowAdorn;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.weight.GuildFeedCommentEmojiShortcutBar;
import com.tencent.mobileqq.guild.feed.widget.comment.CommentEditText;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00060\u0001j\u0002`\u0002:\u0001\u0019B\u0013\u0012\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001a\u0010\u0012\u001a\u00020\t2\u0010\u0010\u0011\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/f;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputActor;", "", "j", "Landroid/view/View;", "clickedView", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/weight/GuildFeedCommentEmojiShortcutBar$a;", "bean", "", "i", "", "emoLocalId", "l", "Lxk1/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindow;", "inputWindow", "e", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputAttachInfo;", "attachInfo", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;)V", "f", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f extends NativeDetailInputWindowDirector.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull NativeDetailInputWindowDirector.b attachInfo) {
        super(attachInfo);
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
    }

    private final void i(View clickedView, GuildFeedCommentEmojiShortcutBar.a bean) {
        CommentEditText a16 = b().X().v().a();
        String emoString = HostEmotionUtil.getEmoString(1, bean.a());
        if (!TextUtils.isEmpty(emoString) && a16.getEditableText() != null) {
            a16.i("EmojiShortcutBarActor", emoString);
            a16.requestFocus();
            l(bean.a());
        }
    }

    private final boolean j() {
        if (getAttachInfo().a() == 7) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(f this$0, View view, GuildFeedCommentEmojiShortcutBar.a emoticonBean) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("EmojiShortcutBarActor", 1, "onEmoji Item click emoticonBean=" + emoticonBean);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        Intrinsics.checkNotNullExpressionValue(emoticonBean, "emoticonBean");
        this$0.i(view, emoticonBean);
    }

    private final void l(int emoLocalId) {
        Map<String, ? extends Object> mapOf;
        gl1.b bVar = (gl1.b) b().getRouter().b(gl1.b.class);
        if (bVar != null) {
            GuildFeedCommentEmojiShortcutBar emoShortcut = b().X().v().getEmoShortcut();
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_emotion_id", Integer.valueOf(emoLocalId)));
            bVar.d(emoShortcut, mapOf);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.a
    public void e(@NotNull xk1.d<NativeDetailInputWindowAdorn> inputWindow) {
        Intrinsics.checkNotNullParameter(inputWindow, "inputWindow");
        super.e(inputWindow);
        GuildFeedCommentEmojiShortcutBar emoShortcut = inputWindow.X().v().getEmoShortcut();
        QLog.i("EmojiShortcutBarActor", 1, "onInputWindowInitialized curTroopFeed=" + j());
        if (!j()) {
            emoShortcut.setVisibility(0);
            emoShortcut.c(new GuildFeedCommentEmojiShortcutBar.b() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.e
                @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.weight.GuildFeedCommentEmojiShortcutBar.b
                public final void a(View view, GuildFeedCommentEmojiShortcutBar.a aVar) {
                    f.k(f.this, view, aVar);
                }
            });
        } else {
            emoShortcut.setVisibility(8);
        }
    }
}
