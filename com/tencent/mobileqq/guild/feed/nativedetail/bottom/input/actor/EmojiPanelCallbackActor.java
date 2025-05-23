package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowAdorn;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector;
import com.tencent.mobileqq.guild.feed.widget.comment.CommentEditText;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001 B\u0013\u0012\n\u0010\u001c\u001a\u00060\u001aj\u0002`\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u001a\u0010\r\u001a\u00020\u00062\u0010\u0010\f\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u0016\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/EmojiPanelCallbackActor;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputActor;", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "info", "", "i", tl.h.F, "Lxk1/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindow;", "inputWindow", "e", "delete", "send", "", NodeProps.ON_LONG_CLICK, "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "onShowPopup", "onHidePopup", "setting", "emoticonMall", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputAttachInfo;", "attachInfo", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;)V", "f", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class EmojiPanelCallbackActor extends NativeDetailInputWindowDirector.a implements EmoticonCallback {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final a f220483f = new a(null);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/EmojiPanelCallbackActor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiPanelCallbackActor(@NotNull NativeDetailInputWindowDirector.b attachInfo) {
        super(attachInfo);
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
    }

    private final void h() {
        CommentEditText a16 = b().X().v().a();
        if (a16.getSelectionStart() == 0) {
            return;
        }
        try {
            Editable text = a16.getText();
            int selectionStart = a16.getSelectionStart();
            int offsetBefore = TextUtils.getOffsetBefore(a16.getText(), selectionStart);
            if (selectionStart != offsetBefore) {
                text.delete(Math.min(selectionStart, offsetBefore), Math.max(selectionStart, offsetBefore));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private final void i(EmoticonInfo info) {
        CommentEditText a16 = b().X().v().a();
        if (info instanceof SystemEmoticonInfo) {
            int selectionStart = a16.getSelectionStart();
            int selectionEnd = a16.getSelectionEnd();
            if (selectionStart >= 0 && selectionEnd >= 0 && selectionEnd >= selectionStart) {
                a16.i("EmojiPanelCallbackActor", ho1.d.d(((SystemEmoticonInfo) info).code));
                return;
            }
            return;
        }
        if (info instanceof SystemAndEmojiEmoticonInfo) {
            int selectionStart2 = a16.getSelectionStart();
            int selectionEnd2 = a16.getSelectionEnd();
            SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) info;
            int i3 = systemAndEmojiEmoticonInfo.emotionType;
            int i16 = systemAndEmojiEmoticonInfo.code;
            if (selectionStart2 >= 0 && selectionEnd2 >= 0 && selectionEnd2 >= selectionStart2) {
                if (i3 == 2 && i16 == -1) {
                    return;
                }
                String b16 = ho1.d.b(i3, i16);
                if (b16 != null && a16.getEditableText() != null) {
                    a16.i("EmojiPanelCallbackActor", b16);
                }
            }
            ho1.d.a(b().X().v().getEmotionPanelView(), systemAndEmojiEmoticonInfo);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void delete() {
        h();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.a
    public void e(@NotNull final xk1.d<NativeDetailInputWindowAdorn> inputWindow) {
        Intrinsics.checkNotNullParameter(inputWindow, "inputWindow");
        super.e(inputWindow);
        inputWindow.X().D(this);
        jt1.b.b(inputWindow.X().v().getEmotionButton(), new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.EmojiPanelCallbackActor$onInputWindowInitialized$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (inputWindow.isShowing()) {
                    inputWindow.Y().e(1);
                    gl1.b bVar = (gl1.b) inputWindow.getRouter().b(gl1.b.class);
                    if (bVar != null) {
                        bVar.c(it);
                    }
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public boolean onLongClick(@Nullable EmoticonInfo info) {
        return false;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send() {
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send(@Nullable EmoticonInfo info) {
        if (info != null) {
            i(info);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void emoticonMall() {
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void setting() {
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onHidePopup(@Nullable EmoticonInfo info) {
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onShowPopup(@Nullable EmoticonInfo oldInfo, @Nullable EmoticonInfo newInfo, @Nullable Drawable d16) {
    }
}
