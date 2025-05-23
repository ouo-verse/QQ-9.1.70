package com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar;

import android.text.Editable;
import android.text.Selection;
import android.text.style.ReplacementSpan;
import com.tencent.guild.aio.input.at.trooptag.dialogui.bean.HashTagPageType;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher;
import com.tencent.mobileqq.guild.feed.nativepublish.functionbar.GuildFeedPublishFunctionBarMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorAtUseCaseMsgIntent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001#B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b \u0010!J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J(\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\rH\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\"\u0010\u001a\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001b8\u0016@\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/SpecialCharDetectTextWatcher$b;", "", "", "text", "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "", "f", "Z", "isAtSupported", tl.h.F, "isAsteriskSupported", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "()Z", "i", "(Z)V", "isActivatable", "Lcom/tencent/mvi/base/route/j;", "()Lcom/tencent/mvi/base/route/j;", "j", "(Lcom/tencent/mvi/base/route/j;)V", "messenger", "<init>", "(ZZ)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends SpecialCharDetectTextWatcher.b {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isAtSupported;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean isAsteriskSupported;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ com.tencent.input.base.util.framework.delegates.impl.a f221947i = new com.tencent.input.base.util.framework.delegates.impl.a();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isActivatable;

    public a(boolean z16, boolean z17) {
        this.isAtSupported = z16;
        this.isAsteriskSupported = z17;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher.b, android.text.TextWatcher
    public void afterTextChanged(@NotNull Editable text) {
        boolean z16;
        Intrinsics.checkNotNullParameter(text, "text");
        int selectionStart = Selection.getSelectionStart(text);
        if (text.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && selectionStart > 0) {
            if (((this.isAtSupported && text.charAt(selectionStart - 1) == '@') || text.charAt(selectionStart - 1) == '\uff20') && !so0.e.b(text, selectionStart - 1, 0, selectionStart, ReplacementSpan.class)) {
                i(true);
                com.tencent.mvi.base.route.j h16 = h();
                if (h16 != null) {
                    h16.h(FeedEditorAtUseCaseMsgIntent.OpenAtPanel.f222389d);
                }
            }
            if (((this.isAsteriskSupported && text.charAt(selectionStart - 1) == '*') || text.charAt(selectionStart - 1) == '\uff0a') && !so0.e.b(text, selectionStart - 1, 0, selectionStart, ReplacementSpan.class)) {
                i(true);
                com.tencent.mvi.base.route.j h17 = h();
                if (h17 != null) {
                    h17.h(new GuildFeedPublishFunctionBarMsgIntent.OpenPlusTag(HashTagPageType.Channel_Page));
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher.b, android.text.TextWatcher
    public void beforeTextChanged(@NotNull CharSequence text, int start, int count, int after) {
        Intrinsics.checkNotNullParameter(text, "text");
        i(false);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher.b
    /* renamed from: d, reason: from getter */
    public boolean getIsActivatable() {
        return this.isActivatable;
    }

    @Nullable
    public com.tencent.mvi.base.route.j h() {
        return this.f221947i.a();
    }

    public void i(boolean z16) {
        this.isActivatable = z16;
    }

    public void j(@Nullable com.tencent.mvi.base.route.j jVar) {
        this.f221947i.b(jVar);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher.b, android.text.TextWatcher
    public void onTextChanged(@NotNull CharSequence text, int start, int before, int count) {
        Intrinsics.checkNotNullParameter(text, "text");
        i(false);
    }
}
