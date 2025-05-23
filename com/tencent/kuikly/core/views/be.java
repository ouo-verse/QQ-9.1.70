package com.tencent.kuikly.core.views;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b2\u00103J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bJ\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0002R\"\u0010\r\u001a\u00020\u000b8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R*\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010%8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\u00a8\u00064"}, d2 = {"Lcom/tencent/kuikly/core/views/be;", "Lcom/tencent/kuikly/core/views/ao;", "", "width", "", "pageItemWidth", "height", "pageItemHeight", "", "isHorizontal", "pageDirection", "", "defaultIndex", "defaultPageIndex", "alive", "keepItemAlive", "maxIndex", "firstContentLoadMaxIndex", "ratio", "setIndexRatio", "I", "getDefaultPageIndex$core_release", "()I", "setDefaultPageIndex$core_release", "(I)V", "Z", "getKeepItemAlive", "()Z", "setKeepItemAlive", "(Z)V", "Ljava/lang/Float;", "getPageItemWidth$core_release", "()Ljava/lang/Float;", "setPageItemWidth$core_release", "(Ljava/lang/Float;)V", "getPageItemHeight$core_release", "setPageItemHeight$core_release", "Lkotlin/Function0;", "pageItemSizeChangeCallback", "Lkotlin/jvm/functions/Function0;", "getPageItemSizeChangeCallback$core_release", "()Lkotlin/jvm/functions/Function0;", "setPageItemSizeChangeCallback$core_release", "(Lkotlin/jvm/functions/Function0;)V", "indexRatio", UserInfo.SEX_FEMALE, "getIndexRatio$core_release", "()F", "setIndexRatio$core_release", "(F)V", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class be extends ao {
    private int defaultPageIndex;
    private float indexRatio = 0.05f;
    private boolean keepItemAlive;
    private Float pageItemHeight;
    private Function0<Unit> pageItemSizeChangeCallback;
    private Float pageItemWidth;

    public be() {
        setFirstContentLoadMaxIndex(1);
    }

    public final void defaultPageIndex(int defaultIndex) {
        this.defaultPageIndex = defaultIndex;
        firstContentLoadMaxIndex(getFirstContentLoadMaxIndex());
    }

    @Override // com.tencent.kuikly.core.views.ao
    public void firstContentLoadMaxIndex(int maxIndex) {
        super.firstContentLoadMaxIndex(Math.max(maxIndex, this.defaultPageIndex + 1));
    }

    /* renamed from: getDefaultPageIndex$core_release, reason: from getter */
    public final int getDefaultPageIndex() {
        return this.defaultPageIndex;
    }

    /* renamed from: getIndexRatio$core_release, reason: from getter */
    public final float getIndexRatio() {
        return this.indexRatio;
    }

    public final boolean getKeepItemAlive() {
        return this.keepItemAlive;
    }

    /* renamed from: getPageItemHeight$core_release, reason: from getter */
    public final Float getPageItemHeight() {
        return this.pageItemHeight;
    }

    public final Function0<Unit> getPageItemSizeChangeCallback$core_release() {
        return this.pageItemSizeChangeCallback;
    }

    /* renamed from: getPageItemWidth$core_release, reason: from getter */
    public final Float getPageItemWidth() {
        return this.pageItemWidth;
    }

    public final void keepItemAlive(boolean alive) {
        this.keepItemAlive = alive;
    }

    public final void pageItemHeight(float height) {
        Function0<Unit> function0;
        float a16 = com.tencent.kuikly.core.utils.b.a(height);
        boolean z16 = !Intrinsics.areEqual(this.pageItemHeight, a16);
        this.pageItemHeight = Float.valueOf(a16);
        mo141height(a16);
        if (!z16 || (function0 = this.pageItemSizeChangeCallback) == null) {
            return;
        }
        function0.invoke();
    }

    public final void pageItemWidth(float width) {
        Function0<Unit> function0;
        float a16 = com.tencent.kuikly.core.utils.b.a(width);
        boolean z16 = !Intrinsics.areEqual(this.pageItemWidth, a16);
        this.pageItemWidth = Float.valueOf(a16);
        mo153width(a16);
        if (!z16 || (function0 = this.pageItemSizeChangeCallback) == null) {
            return;
        }
        function0.invoke();
    }

    public final void setDefaultPageIndex$core_release(int i3) {
        this.defaultPageIndex = i3;
    }

    public final void setIndexRatio(float ratio) {
        this.indexRatio = ratio;
    }

    public final void setIndexRatio$core_release(float f16) {
        this.indexRatio = f16;
    }

    public final void setKeepItemAlive(boolean z16) {
        this.keepItemAlive = z16;
    }

    public final void setPageItemHeight$core_release(Float f16) {
        this.pageItemHeight = f16;
    }

    public final void setPageItemSizeChangeCallback$core_release(Function0<Unit> function0) {
        this.pageItemSizeChangeCallback = function0;
    }

    public final void setPageItemWidth$core_release(Float f16) {
        this.pageItemWidth = f16;
    }

    public final void pageDirection(boolean isHorizontal) {
        if (isHorizontal) {
            flexDirectionRow();
        } else {
            flexDirectionColumn();
        }
    }

    public static /* synthetic */ void setIndexRatio$default(be beVar, float f16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                f16 = 0.05f;
            }
            beVar.setIndexRatio(f16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setIndexRatio");
    }
}
