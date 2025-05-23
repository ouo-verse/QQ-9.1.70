package com.tencent.now.pkgame.linkscreen.followbuttom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.R;
import com.tencent.now.pkgame.linkscreen.followbuttom.FollowLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import eo3.c;
import hn3.LinkScreenAnchorInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mm4.b;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/now/pkgame/linkscreen/followbuttom/FollowLayout;", "Landroid/widget/LinearLayout;", "Ldo3/a;", "", "d", "f", "", QCircleDaTongConstant.ElementParamValue.FOLLOWED, "g", "Landroid/view/View;", "view", "", "followStatus", "", "otherAnchorId", "c", "unInit", "Lhn3/a;", "Lhn3/a;", "linkScreenAnchorInfo", "Leo3/c;", "e", "Leo3/c;", "followLayoutModel", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "anchorName", "Landroid/widget/ImageView;", h.F, "Landroid/widget/ImageView;", "followBtn", "i", "Z", "isFollowed", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lhn3/a;)V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class FollowLayout extends LinearLayout implements do3.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkScreenAnchorInfo linkScreenAnchorInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c followLayoutModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView anchorName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView followBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isFollowed;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/pkgame/linkscreen/followbuttom/FollowLayout$a", "Leo3/c$b;", "", QCircleDaTongConstant.ElementParamValue.FOLLOWED, "", "onSuccess", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements c.b {
        a() {
        }

        @Override // eo3.c.b
        public void onSuccess(boolean followed) {
            FollowLayout.this.g(followed);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowLayout(@NotNull Context context, @NotNull LinkScreenAnchorInfo linkScreenAnchorInfo) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(linkScreenAnchorInfo, "linkScreenAnchorInfo");
        this.linkScreenAnchorInfo = linkScreenAnchorInfo;
        this.followLayoutModel = new c(context, linkScreenAnchorInfo);
        d();
        f();
    }

    private final void c(View view, int followStatus, String otherAnchorId) {
        String str;
        if (followStatus == 1) {
            str = String.valueOf(followStatus);
        } else {
            str = "0";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("zengzhi_moduleid", "em_qqlive_pk_follow_entrance");
        hashMap.put("qqlive_follow_status", str);
        hashMap.put("qqlive_inf_module_user_id", otherAnchorId);
        ((ug4.a) b.b(ug4.a.class)).a(view, true, null, "em_qqlive_pk_follow_entrance", hashMap);
    }

    private final void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.has, this);
        View findViewById = findViewById(R.id.f1059967i);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.anchorName = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.tcs);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        this.followBtn = (ImageView) findViewById2;
        TextView textView = this.anchorName;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorName");
            textView = null;
        }
        RFWTypefaceUtil.setNumberTypeface(textView, "https://dlied5v6.qq.com/now/qq-live/fonts/EurostileNextPro-SemiBold\u7684.ttf");
        ImageView imageView2 = this.followBtn;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("followBtn");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: eo3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FollowLayout.e(FollowLayout.this, view);
            }
        });
        this.followLayoutModel.m(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(FollowLayout this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = null;
        if (this$0.isFollowed) {
            this$0.followLayoutModel.g();
            ImageView imageView2 = this$0.followBtn;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("followBtn");
            } else {
                imageView = imageView2;
            }
            imageView.setImageResource(R.drawable.noh);
        } else {
            this$0.followLayoutModel.f();
            ImageView imageView3 = this$0.followBtn;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("followBtn");
            } else {
                imageView = imageView3;
            }
            imageView.setImageResource(R.drawable.noi);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void f() {
        LinkScreenAnchorInfo linkScreenAnchorInfo = this.linkScreenAnchorInfo;
        TextView textView = this.anchorName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorName");
            textView = null;
        }
        textView.setText(linkScreenAnchorInfo.getNick());
        this.followLayoutModel.l(linkScreenAnchorInfo.getUin());
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(boolean followed) {
        ImageView imageView = null;
        if (followed) {
            ImageView imageView2 = this.followBtn;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("followBtn");
                imageView2 = null;
            }
            imageView2.setImageResource(R.drawable.noi);
        } else {
            ImageView imageView3 = this.followBtn;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("followBtn");
                imageView3 = null;
            }
            imageView3.setImageResource(R.drawable.noh);
        }
        this.isFollowed = followed;
        ImageView imageView4 = this.followBtn;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("followBtn");
        } else {
            imageView = imageView4;
        }
        c(imageView, this.followLayoutModel.getFollowStatus(), this.followLayoutModel.j());
    }

    @Override // do3.a
    public void unInit() {
        this.followLayoutModel.e();
    }
}
