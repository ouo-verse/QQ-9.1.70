package com.tencent.timi.game.liveroom.impl.room.util;

import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b1\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bA\u0010BR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010!\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010R\"\u0010$\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\f\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010R\"\u0010&\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b%\u0010\u0018R\"\u0010)\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016\"\u0004\b(\u0010\u0018R\"\u0010+\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0003\u0010\u0016\"\u0004\b*\u0010\u0018R\"\u0010/\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\f\u001a\u0004\b-\u0010\u000e\"\u0004\b.\u0010\u0010R\"\u00102\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\f\u001a\u0004\b0\u0010\u000e\"\u0004\b1\u0010\u0010R\"\u00105\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\f\u001a\u0004\b3\u0010\u000e\"\u0004\b4\u0010\u0010R\"\u00107\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\f\u001a\u0004\b,\u0010\u000e\"\u0004\b6\u0010\u0010R\"\u00109\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u0014\u001a\u0004\b\u000b\u0010\u0016\"\u0004\b8\u0010\u0018R\"\u0010;\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b:\u0010\u0018R$\u0010@\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010<\u001a\u0004\b'\u0010=\"\u0004\b>\u0010?\u00a8\u0006C"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/util/h;", "", "Lcom/tencent/timi/game/liveroom/impl/room/util/PopWindowType;", "a", "Lcom/tencent/timi/game/liveroom/impl/room/util/PopWindowType;", "i", "()Lcom/tencent/timi/game/liveroom/impl/room/util/PopWindowType;", "w", "(Lcom/tencent/timi/game/liveroom/impl/room/util/PopWindowType;)V", "popType", "", "b", "Z", "l", "()Z", "t", "(Z)V", "isOriginDp", "", "c", "I", "f", "()I", "u", "(I)V", "originHeight", "d", "g", "v", "originWidth", "e", "o", "setSupportFolder", "isSupportFolder", "k", "setFolderDp", "isFolderDp", ReportConstant.COSTREPORT_PREFIX, "folderWidth", tl.h.F, "r", "folderHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "animationStyle", "j", DomainData.DOMAIN_NAME, HippyTKDListViewAdapter.X, "isShowAnim", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setOutsideTouchable", "isOutsideTouchable", "p", "setTouchable", "isTouchable", "setFocusable", "isFocusable", "setColor", "color", "setGravity", LayoutAttrDefine.Gravity.Gravity, "Ljava/lang/Object;", "()Ljava/lang/Object;", "setParam", "(Ljava/lang/Object;)V", "param", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class h {

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int color;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Object param;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PopWindowType popType = PopWindowType.NORMAL;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isOriginDp = true;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int originHeight = -2;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int originWidth = -1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isSupportFolder = true;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isFolderDp = true;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int folderWidth = 320;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int folderHeight = 400;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int animationStyle = R.style.b0e;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isShowAnim = true;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isOutsideTouchable = true;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean isTouchable = true;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isFocusable = true;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int gravity = 80;

    /* renamed from: a, reason: from getter */
    public final int getAnimationStyle() {
        return this.animationStyle;
    }

    /* renamed from: b, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* renamed from: c, reason: from getter */
    public final int getFolderHeight() {
        return this.folderHeight;
    }

    /* renamed from: d, reason: from getter */
    public final int getFolderWidth() {
        return this.folderWidth;
    }

    /* renamed from: e, reason: from getter */
    public final int getGravity() {
        return this.gravity;
    }

    /* renamed from: f, reason: from getter */
    public final int getOriginHeight() {
        return this.originHeight;
    }

    /* renamed from: g, reason: from getter */
    public final int getOriginWidth() {
        return this.originWidth;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final Object getParam() {
        return this.param;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final PopWindowType getPopType() {
        return this.popType;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsFocusable() {
        return this.isFocusable;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getIsFolderDp() {
        return this.isFolderDp;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsOriginDp() {
        return this.isOriginDp;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getIsOutsideTouchable() {
        return this.isOutsideTouchable;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getIsShowAnim() {
        return this.isShowAnim;
    }

    /* renamed from: o, reason: from getter */
    public final boolean getIsSupportFolder() {
        return this.isSupportFolder;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getIsTouchable() {
        return this.isTouchable;
    }

    public final void q(int i3) {
        this.animationStyle = i3;
    }

    public final void r(int i3) {
        this.folderHeight = i3;
    }

    public final void s(int i3) {
        this.folderWidth = i3;
    }

    public final void t(boolean z16) {
        this.isOriginDp = z16;
    }

    public final void u(int i3) {
        this.originHeight = i3;
    }

    public final void v(int i3) {
        this.originWidth = i3;
    }

    public final void w(@NotNull PopWindowType popWindowType) {
        Intrinsics.checkNotNullParameter(popWindowType, "<set-?>");
        this.popType = popWindowType;
    }

    public final void x(boolean z16) {
        this.isShowAnim = z16;
    }
}
