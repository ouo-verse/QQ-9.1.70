package com.tencent.guild.aio.msglist.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0002-.B\u0011\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(B\u001b\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u00a2\u0006\u0004\b'\u0010+J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\"\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001d\u00a8\u0006/"}, d2 = {"Lcom/tencent/guild/aio/msglist/view/RecyclerViewCompatRefresh;", "Landroidx/recyclerview/widget/RecyclerView;", "", "", "init", "", BdhLogUtil.LogTag.Tag_Conn, "D", "Lcom/tencent/guild/aio/msglist/view/RecyclerViewCompatRefresh$b;", "refreshConfig", "setRefreshHandler", "Landroid/view/MotionEvent;", "e", "onTouchEvent", "", "f", UserInfo.SEX_FEMALE, "mLastY", h.F, "mSumOffset", "", "i", "I", "mActivePointerId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "getMRefreshing", "()Z", "setMRefreshing", "(Z)V", "mRefreshing", "getEnablePullToDownRefresh", "setEnablePullToDownRefresh", "enablePullToDownRefresh", "getEnablePullToTopRefresh", "setEnablePullToTopRefresh", "enablePullToTopRefresh", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "E", "a", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class RecyclerViewCompatRefresh extends RecyclerView {
    private static float F = 1.5f;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean enablePullToDownRefresh;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean enablePullToTopRefresh;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mLastY;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float mSumOffset;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mActivePointerId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mRefreshing;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/guild/aio/msglist/view/RecyclerViewCompatRefresh$b;", "", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public interface b {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerViewCompatRefresh(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLastY = -1.0f;
        this.enablePullToTopRefresh = true;
        init();
    }

    private final boolean C() {
        return false;
    }

    private final boolean D() {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent e16) {
        boolean z16;
        Intrinsics.checkNotNullParameter(e16, "e");
        int i3 = 0;
        if (this.mLastY == -1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mLastY = e16.getY();
            this.mActivePointerId = e16.getPointerId(0);
            this.mSumOffset = 0.0f;
        }
        int actionMasked = e16.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 5) {
                        this.mLastY = -1.0f;
                        this.mActivePointerId = -1;
                        this.mRefreshing = false;
                    } else {
                        int actionIndex = e16.getActionIndex();
                        this.mActivePointerId = e16.getPointerId(actionIndex);
                        this.mLastY = e16.getY(actionIndex);
                    }
                } else {
                    int findPointerIndex = e16.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        this.mActivePointerId = e16.getPointerId(0);
                    } else {
                        i3 = findPointerIndex;
                    }
                    float y16 = e16.getY(i3);
                    float f16 = (y16 - this.mLastY) / F;
                    this.mLastY = y16;
                    if (C() && !D()) {
                        this.mSumOffset += f16;
                    } else if (D() && !C()) {
                        this.mSumOffset += f16;
                    }
                }
            } else {
                this.mLastY = -1.0f;
                this.mActivePointerId = -1;
                if (C()) {
                    this.mRefreshing = true;
                } else if (D()) {
                    this.mRefreshing = true;
                }
            }
        } else {
            this.mLastY = e16.getY();
            this.mActivePointerId = e16.getPointerId(0);
            this.mSumOffset = 0.0f;
        }
        return super.onTouchEvent(e16);
    }

    public final void setEnablePullToDownRefresh(boolean z16) {
        this.enablePullToDownRefresh = z16;
    }

    public final void setEnablePullToTopRefresh(boolean z16) {
        this.enablePullToTopRefresh = z16;
    }

    public final void setMRefreshing(boolean z16) {
        this.mRefreshing = z16;
    }

    public void setRefreshHandler(@NotNull b refreshConfig) {
        Intrinsics.checkNotNullParameter(refreshConfig, "refreshConfig");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerViewCompatRefresh(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLastY = -1.0f;
        this.enablePullToTopRefresh = true;
        init();
    }

    private final void init() {
    }
}
