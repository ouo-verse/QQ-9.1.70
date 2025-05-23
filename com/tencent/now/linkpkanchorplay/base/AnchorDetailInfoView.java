package com.tencent.now.linkpkanchorplay.base;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import e55.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import u0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fB\u001b\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b\u001e\u0010\"B#\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b\u001e\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006&"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/base/AnchorDetailInfoView;", "Landroid/widget/FrameLayout;", "", "a", "Le55/a;", "info", "c", "b", "anchorInfo", "setAnchorInfo", "", "d", "Ljava/lang/String;", "PK_LIVING_URL", "Lcom/tencent/now/linkpkanchorplay/base/LinkPKHeadImageView;", "e", "Lcom/tencent/now/linkpkanchorplay/base/LinkPKHeadImageView;", "avatarView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "nickName", h.F, "flagLabel", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "avatarTag", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class AnchorDetailInfoView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String PK_LIVING_URL;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinkPKHeadImageView avatarView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView nickName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView flagLabel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView avatarTag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorDetailInfoView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.PK_LIVING_URL = "https://dlied5.qq.com/now/qq-live/images/pk-living.png";
        View.inflate(getContext(), R.layout.fdt, this);
        a();
    }

    private final void a() {
        View findViewById = findViewById(R.id.a2o);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<LinkPKHeadImageView>(R.id.avatar)");
        this.avatarView = (LinkPKHeadImageView) findViewById;
        View findViewById2 = getRootView().findViewById(R.id.f9d);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<TextView>(R.id.nick_name)");
        this.nickName = (TextView) findViewById2;
        View findViewById3 = getRootView().findViewById(R.id.f165287vf2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById<TextView>(R.id.friend_flag)");
        this.flagLabel = (TextView) findViewById3;
        View findViewById4 = getRootView().findViewById(R.id.yko);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.live_anim_view)");
        this.avatarTag = (ImageView) findViewById4;
    }

    private final void b() {
        a.c cVar = new a.c(0, true, true);
        a h16 = a.h();
        String str = this.PK_LIVING_URL;
        ImageView imageView = this.avatarTag;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarTag");
            imageView = null;
        }
        h16.c(str, imageView, cVar);
    }

    private final void c(e55.a info) {
        boolean z16;
        d[] dVarArr = info.f395731c;
        if (dVarArr != null) {
            Intrinsics.checkNotNullExpressionValue(dVarArr, "info.tags");
            if (dVarArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                int length = info.f395731c.length;
                for (int i3 = 0; i3 < length; i3++) {
                    String str = info.f395731c[i3].f395740a;
                    if (!TextUtils.isEmpty(str) && str.equals(getContext().getString(R.string.f1358402j))) {
                        TextView textView = this.flagLabel;
                        TextView textView2 = null;
                        if (textView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("flagLabel");
                            textView = null;
                        }
                        textView.setVisibility(0);
                        TextView textView3 = this.flagLabel;
                        if (textView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("flagLabel");
                        } else {
                            textView2 = textView3;
                        }
                        textView2.setText(str);
                    }
                }
            }
        }
    }

    public final void setAnchorInfo(@NotNull e55.a anchorInfo) {
        Intrinsics.checkNotNullParameter(anchorInfo, "anchorInfo");
        ImageLoader imageLoader = ImageLoader.getInstance();
        String str = anchorInfo.f395729a.f395738d;
        LinkPKHeadImageView linkPKHeadImageView = this.avatarView;
        TextView textView = null;
        if (linkPKHeadImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            linkPKHeadImageView = null;
        }
        imageLoader.displayImage(str, linkPKHeadImageView, hm3.a.a());
        TextView textView2 = this.nickName;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickName");
        } else {
            textView = textView2;
        }
        textView.setText(anchorInfo.f395729a.f395737c);
        c(anchorInfo);
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorDetailInfoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.PK_LIVING_URL = "https://dlied5.qq.com/now/qq-live/images/pk-living.png";
        View.inflate(getContext(), R.layout.fdt, this);
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorDetailInfoView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.PK_LIVING_URL = "https://dlied5.qq.com/now/qq-live/images/pk-living.png";
        View.inflate(getContext(), R.layout.fdt, this);
        a();
    }
}
