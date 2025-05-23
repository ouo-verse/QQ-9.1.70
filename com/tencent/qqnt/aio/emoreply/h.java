package com.tencent.qqnt.aio.emoreply;

import android.view.View;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.emotion.info.SystemAndEmojiEmotionInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgEmojiLikes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\u0011\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\"\u001a\u00020\u0011\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010.\u001a\u00020)\u00a2\u0006\u0004\b/\u00100R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\t\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\"\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b!\u0010\u0017R$\u0010(\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010$\u001a\u0004\b\u0012\u0010%\"\u0004\b&\u0010'R\"\u0010.\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010*\u001a\u0004\b\u0003\u0010+\"\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/aio/emoreply/h;", "", "Lcom/tencent/qqnt/emotion/info/SystemAndEmojiEmotionInfo;", "a", "Lcom/tencent/qqnt/emotion/info/SystemAndEmojiEmotionInfo;", "b", "()Lcom/tencent/qqnt/emotion/info/SystemAndEmojiEmotionInfo;", "emotionInfo", "", "[I", "f", "()[I", "startLocation", "c", "j", "([I)V", "endLocation", "", "d", "Z", tl.h.F, "()Z", "setParabola", "(Z)V", "isParabola", "Landroid/view/View;", "e", "Landroid/view/View;", "g", "()Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Landroid/view/View;)V", "targetView", "l", "newlyAdded", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgEmojiLikes;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgEmojiLikes;", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgEmojiLikes;", "k", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgEmojiLikes;)V", "msgEmojiLikes", "", "I", "()I", "i", "(I)V", "bottomPaddingIncrement", "<init>", "(Lcom/tencent/qqnt/emotion/info/SystemAndEmojiEmotionInfo;[I[IZLandroid/view/View;ZLcom/tencent/qqnt/kernel/nativeinterface/MsgEmojiLikes;I)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SystemAndEmojiEmotionInfo emotionInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] startLocation;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private int[] endLocation;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isParabola;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View targetView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean newlyAdded;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MsgEmojiLikes msgEmojiLikes;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int bottomPaddingIncrement;

    public h(@NotNull SystemAndEmojiEmotionInfo emotionInfo, @NotNull int[] startLocation, @NotNull int[] endLocation, boolean z16, @Nullable View view, boolean z17, @Nullable MsgEmojiLikes msgEmojiLikes, int i3) {
        Intrinsics.checkNotNullParameter(emotionInfo, "emotionInfo");
        Intrinsics.checkNotNullParameter(startLocation, "startLocation");
        Intrinsics.checkNotNullParameter(endLocation, "endLocation");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, emotionInfo, startLocation, endLocation, Boolean.valueOf(z16), view, Boolean.valueOf(z17), msgEmojiLikes, Integer.valueOf(i3));
            return;
        }
        this.emotionInfo = emotionInfo;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.isParabola = z16;
        this.targetView = view;
        this.newlyAdded = z17;
        this.msgEmojiLikes = msgEmojiLikes;
        this.bottomPaddingIncrement = i3;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.bottomPaddingIncrement;
    }

    @NotNull
    public final SystemAndEmojiEmotionInfo b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SystemAndEmojiEmotionInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.emotionInfo;
    }

    @NotNull
    public final int[] c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (int[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.endLocation;
    }

    @Nullable
    public final MsgEmojiLikes d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (MsgEmojiLikes) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.msgEmojiLikes;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.newlyAdded;
    }

    @NotNull
    public final int[] f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.startLocation;
    }

    @Nullable
    public final View g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.targetView;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.isParabola;
    }

    public final void i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else {
            this.bottomPaddingIncrement = i3;
        }
    }

    public final void j(@NotNull int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) iArr);
        } else {
            Intrinsics.checkNotNullParameter(iArr, "<set-?>");
            this.endLocation = iArr;
        }
    }

    public final void k(@Nullable MsgEmojiLikes msgEmojiLikes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) msgEmojiLikes);
        } else {
            this.msgEmojiLikes = msgEmojiLikes;
        }
    }

    public final void l(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.newlyAdded = z16;
        }
    }

    public final void m(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            this.targetView = view;
        }
    }

    public /* synthetic */ h(SystemAndEmojiEmotionInfo systemAndEmojiEmotionInfo, int[] iArr, int[] iArr2, boolean z16, View view, boolean z17, MsgEmojiLikes msgEmojiLikes, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(systemAndEmojiEmotionInfo, iArr, iArr2, z16, (i16 & 16) != 0 ? null : view, (i16 & 32) != 0 ? false : z17, (i16 & 64) != 0 ? null : msgEmojiLikes, (i16 & 128) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, systemAndEmojiEmotionInfo, iArr, iArr2, Boolean.valueOf(z16), view, Boolean.valueOf(z17), msgEmojiLikes, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
