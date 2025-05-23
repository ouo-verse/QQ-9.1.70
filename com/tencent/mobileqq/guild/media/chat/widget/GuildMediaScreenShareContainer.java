package com.tencent.mobileqq.guild.media.chat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u001fB\u001d\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0014J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0014J\u0006\u0010\u0010\u001a\u00020\u0002R\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/media/chat/widget/GuildMediaScreenShareContainer;", "Lcom/tencent/mobileqq/guild/widget/RadiusFrameLayout;", "", "i", "", "k", "", "newScale", "j", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "g", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "mScale", "D", "I", "mLayoutWidth", "E", "mLayoutHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaScreenShareContainer extends RadiusFrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private float mScale;

    /* renamed from: D, reason: from kotlin metadata */
    private int mLayoutWidth;

    /* renamed from: E, reason: from kotlin metadata */
    private int mLayoutHeight;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaScreenShareContainer(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(GuildMediaScreenShareContainer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i();
    }

    private final void i() {
        int i3 = x.f(getContext()).f185860a;
        int i16 = x.f(getContext()).f185861b;
        QLog.i("QGMC.GuildMediaScreenShareContainer", 1, "[onLayoutConfigChanged] width: " + i3 + ", height: " + i16);
        if (i16 == this.mLayoutHeight && i3 == this.mLayoutWidth) {
            QLog.i("QGMC.GuildMediaScreenShareContainer", 1, "[onScreenConfigChanged] same: " + i3 + ", " + i16);
            return;
        }
        this.mLayoutWidth = i3;
        this.mLayoutHeight = i16;
        if (k()) {
            j(1.0f);
        } else {
            j(0.5f);
        }
    }

    private final void j(float newScale) {
        if (newScale <= 0.0f) {
            QLog.w("QGMC.GuildMediaScreenShareContainer", 1, "[resetScale] failed: scale: " + newScale);
            return;
        }
        QLog.i("QGMC.GuildMediaScreenShareContainer", 1, "[resetScale] " + newScale);
        this.mScale = newScale;
        requestLayout();
    }

    private final boolean k() {
        return !MediaChannelUtils.f228046a.x(this);
    }

    public final void g() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.chat.widget.g
            @Override // java.lang.Runnable
            public final void run() {
                GuildMediaScreenShareContainer.h(GuildMediaScreenShareContainer.this);
            }
        });
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.RadiusFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, (int) (widthMeasureSpec * this.mScale));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaScreenShareContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mScale = 1.0f;
    }

    public /* synthetic */ GuildMediaScreenShareContainer(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
