package com.tencent.mobileqq.wink.editor.view.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.editor.WinkImageTavCut;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.listener.OnClipAssetListener;
import org.light.listener.OnLoadAssetListener;
import s73.a;
import s73.b;
import tl.h;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/B\u001b\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u00101\u001a\u0004\u0018\u000100\u00a2\u0006\u0004\b.\u00102B#\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u00101\u001a\u0004\u0018\u000100\u0012\u0006\u00104\u001a\u000203\u00a2\u0006\u0004\b.\u00105JB\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004R\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0011R\u0014\u0010\u001e\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR(\u0010%\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R(\u0010+\u001a\u0004\u0018\u00010&2\b\u0010 \u001a\u0004\u0018\u00010&8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/view/video/WinkPlayerContainerView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/wink/editor/dr$c;", "param", "Ls73/a;", "Lcom/tencent/mobileqq/wink/editor/WinkVideoTavCut;", "initializer", "Lorg/light/listener/OnLoadAssetListener;", "loadAssetListener", "", "notChangeSize", "Lorg/light/listener/OnClipAssetListener;", "onClipAssetListener", "e", "Lcom/tencent/mobileqq/wink/editor/WinkImageTavCut;", "c", "d", "Z", "isVideoTavCutInit", "Lcom/tencent/mobileqq/wink/editor/WinkVideoTavCut;", "winkVideoTavCut", "f", "Landroid/widget/FrameLayout;", "videoPlayerContainerBack", h.F, "videoPlayerContainerFront", "i", "isImageTavCutInit", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/editor/WinkImageTavCut;", "winkImageTavCut", "Landroidx/viewpager2/widget/ViewPager2;", "<set-?>", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/viewpager2/widget/ViewPager2;", "b", "()Landroidx/viewpager2/widget/ViewPager2;", "imagePlayerContainer", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "a", "()Landroid/widget/TextView;", "imageIndexIndicator", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkPlayerContainerView extends FrameLayout {

    /* renamed from: C */
    @Nullable
    private ViewPager2 imagePlayerContainer;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView imageIndexIndicator;

    @NotNull
    public Map<Integer, View> E;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean isVideoTavCutInit;

    /* renamed from: e, reason: from kotlin metadata */
    @NotNull
    private final WinkVideoTavCut winkVideoTavCut;

    /* renamed from: f, reason: from kotlin metadata */
    @Nullable
    private FrameLayout videoPlayerContainerBack;

    /* renamed from: h */
    @Nullable
    private FrameLayout videoPlayerContainerFront;

    /* renamed from: i, reason: from kotlin metadata */
    private boolean isImageTavCutInit;

    /* renamed from: m */
    @NotNull
    private final WinkImageTavCut winkImageTavCut;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkPlayerContainerView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ WinkVideoTavCut f(WinkPlayerContainerView winkPlayerContainerView, dr.WinkTavCutParams winkTavCutParams, a aVar, OnLoadAssetListener onLoadAssetListener, boolean z16, OnClipAssetListener onClipAssetListener, int i3, Object obj) {
        OnLoadAssetListener onLoadAssetListener2;
        OnClipAssetListener onClipAssetListener2;
        if ((i3 & 2) != 0) {
            aVar = new b();
        }
        a aVar2 = aVar;
        if ((i3 & 4) != 0) {
            onLoadAssetListener2 = null;
        } else {
            onLoadAssetListener2 = onLoadAssetListener;
        }
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        boolean z17 = z16;
        if ((i3 & 16) != 0) {
            onClipAssetListener2 = null;
        } else {
            onClipAssetListener2 = onClipAssetListener;
        }
        return winkPlayerContainerView.e(winkTavCutParams, aVar2, onLoadAssetListener2, z17, onClipAssetListener2);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final TextView getImageIndexIndicator() {
        return this.imageIndexIndicator;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final ViewPager2 getImagePlayerContainer() {
        return this.imagePlayerContainer;
    }

    @NotNull
    public final WinkImageTavCut c(@NotNull dr.WinkTavCutParams param, @NotNull a<WinkImageTavCut> initializer) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        if (this.isImageTavCutInit) {
            return this.winkImageTavCut;
        }
        this.isImageTavCutInit = true;
        LayoutInflater.from(getContext()).inflate(R.layout.hdg, (ViewGroup) this, true);
        this.imagePlayerContainer = (ViewPager2) findViewById(R.id.xhu);
        this.imageIndexIndicator = (TextView) findViewById(R.id.xhr);
        this.winkImageTavCut.b1(this, param, initializer.a(this.winkImageTavCut));
        initializer.b(this.winkImageTavCut);
        return this.winkImageTavCut;
    }

    @JvmOverloads
    @NotNull
    public final WinkVideoTavCut d(@NotNull dr.WinkTavCutParams param, @NotNull a<WinkVideoTavCut> initializer, @Nullable OnLoadAssetListener onLoadAssetListener, boolean z16) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        return f(this, param, initializer, onLoadAssetListener, z16, null, 16, null);
    }

    @JvmOverloads
    @NotNull
    public final WinkVideoTavCut e(@NotNull dr.WinkTavCutParams param, @NotNull a<WinkVideoTavCut> initializer, @Nullable OnLoadAssetListener loadAssetListener, boolean notChangeSize, @Nullable OnClipAssetListener onClipAssetListener) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        if (this.isVideoTavCutInit) {
            return this.winkVideoTavCut;
        }
        this.isVideoTavCutInit = true;
        LayoutInflater.from(getContext()).inflate(R.layout.hez, (ViewGroup) this, true);
        this.videoPlayerContainerBack = (FrameLayout) findViewById(R.id.f1170970i);
        this.videoPlayerContainerFront = (FrameLayout) findViewById(R.id.f1171070j);
        HashMap<String, Object> a16 = initializer.a(this.winkVideoTavCut);
        WinkVideoTavCut winkVideoTavCut = this.winkVideoTavCut;
        winkVideoTavCut.N2(notChangeSize);
        winkVideoTavCut.V1(this.videoPlayerContainerFront, this.videoPlayerContainerBack);
        winkVideoTavCut.O1(this, param, a16, loadAssetListener, onClipAssetListener);
        initializer.b(this.winkVideoTavCut);
        return this.winkVideoTavCut;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkPlayerContainerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkPlayerContainerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.E = new LinkedHashMap();
        this.winkVideoTavCut = new WinkVideoTavCut(null, 1, null);
        this.winkImageTavCut = new WinkImageTavCut(null, 1, null);
    }
}
