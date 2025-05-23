package com.tencent.state.square.api;

import com.tencent.state.square.SquareBaseKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/square/api/SimpleSquarePagViewListener;", "Lcom/tencent/state/square/api/ISquarePagViewListener;", "logMsg", "", "(Ljava/lang/String;)V", "getLogMsg", "()Ljava/lang/String;", "onAnimationCancel", "", "squarePagView", "Lcom/tencent/state/square/api/ISquarePagView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "onAnimationUpdate", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public class SimpleSquarePagViewListener implements ISquarePagViewListener {
    private static final String TAG = "SimpleSquarePagViewListener";

    @Nullable
    private final String logMsg;

    public SimpleSquarePagViewListener() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Nullable
    public final String getLogMsg() {
        return this.logMsg;
    }

    @Override // com.tencent.state.square.api.ISquarePagViewListener
    public void onAnimationCancel(@Nullable ISquarePagView squarePagView) {
        if (SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareBaseKt.getSquareLog().d(TAG, "onAnimationCancel, " + this.logMsg);
        }
    }

    @Override // com.tencent.state.square.api.ISquarePagViewListener
    public void onAnimationEnd(@Nullable ISquarePagView squarePagView) {
        if (SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareBaseKt.getSquareLog().d(TAG, "onAnimationEnd, " + this.logMsg);
        }
    }

    @Override // com.tencent.state.square.api.ISquarePagViewListener
    public void onAnimationRepeat(@Nullable ISquarePagView squarePagView) {
        if (SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareBaseKt.getSquareLog().d(TAG, "onAnimationRepeat, " + this.logMsg);
        }
    }

    @Override // com.tencent.state.square.api.ISquarePagViewListener
    public void onAnimationStart(@Nullable ISquarePagView squarePagView) {
        if (SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareBaseKt.getSquareLog().d(TAG, "onAnimationStart, " + this.logMsg);
        }
    }

    @Override // com.tencent.state.square.api.ISquarePagViewListener
    public void onAnimationUpdate(@Nullable ISquarePagView squarePagView) {
        if (SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareBaseKt.getSquareLog().d(TAG, "onAnimationUpdate, " + this.logMsg);
        }
    }

    public SimpleSquarePagViewListener(@Nullable String str) {
        this.logMsg = str;
    }

    public /* synthetic */ SimpleSquarePagViewListener(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str);
    }
}
