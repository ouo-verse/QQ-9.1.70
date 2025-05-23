package com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wk1.InputStyleConfig;
import wk1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 (2\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0014\u0010\u0017\u001a\u00020\u00042\n\u0010\u0016\u001a\u00060\u0014j\u0002`\u0015H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/ui/k;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/ui/d;", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "j", tl.h.F, "g", "", "shareCount", "k", "init", "", "action", "", "msg", "c", "", "enable", "u1", "Lqj1/b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IBottomInteractDisplayable;", "bottomInteractData", "b", "Lwk1/h;", "d", "Lwk1/h;", "inputContext", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "shareTv", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "shareBtn", "Landroid/view/ViewGroup;", "shareLayout", "<init>", "(Lwk1/h;)V", "i", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class k implements d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final wk1.h inputContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView shareTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView shareBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup shareLayout;

    public k(@NotNull wk1.h inputContext) {
        Intrinsics.checkNotNullParameter(inputContext, "inputContext");
        this.inputContext = inputContext;
    }

    private final void g() {
        ViewGroup viewGroup = this.shareLayout;
        HashMap<String, Object> hashMap = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareLayout");
            viewGroup = null;
        }
        if (o.a(viewGroup)) {
            QLog.i("MainInputShareUI", 1, "handleShareLayoutClick isFastClick");
            return;
        }
        wk1.i delegate = this.inputContext.getDelegate();
        ViewGroup viewGroup2 = this.shareLayout;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareLayout");
            viewGroup2 = null;
        }
        delegate.lh("message_share_feed", viewGroup2);
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        ViewGroup viewGroup3 = this.shareLayout;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareLayout");
            viewGroup3 = null;
        }
        wk1.e c16 = this.inputContext.c();
        if (c16 != null) {
            hashMap = c16.b();
        }
        iGuildDTReportApi.reportDtEventManual(viewGroup3, "em_sgrp_forum_share", "clck", hashMap);
    }

    private final void h(ViewGroup rootView) {
        View findViewById = rootView.findViewById(R.id.f84364m2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.share_layout)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        this.shareLayout = viewGroup;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareLayout");
            viewGroup = null;
        }
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.i(k.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(k this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void j(ViewGroup rootView) {
        Integer iconColor;
        View findViewById = rootView.findViewById(R.id.f84514mg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.share_tv)");
        this.shareTv = (TextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f84344m0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.share_iv)");
        this.shareBtn = (ImageView) findViewById2;
        InputStyleConfig d16 = this.inputContext.d();
        if (d16 != null && (iconColor = d16.getIconColor()) != null) {
            int intValue = iconColor.intValue();
            TextView textView = this.shareTv;
            ImageView imageView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareTv");
                textView = null;
            }
            textView.setTextColor(intValue);
            ImageView imageView2 = this.shareBtn;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareBtn");
            } else {
                imageView = imageView2;
            }
            imageView.setImageDrawable(GuildUIUtils.y(this.inputContext.getContext(), R.drawable.guild_feed_item_share_icon_normal, intValue));
        }
    }

    private final void k(int shareCount) {
        boolean z16;
        String h16 = bl1.b.h(bl1.b.f28597a, shareCount, null, null, 6, null);
        TextView textView = this.shareTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareTv");
            textView = null;
        }
        if (h16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            h16 = this.inputContext.getContext().getString(R.string.f144520p0);
            Intrinsics.checkNotNullExpressionValue(h16, "inputContext.context.get\u2026native_detail_share_tips)");
        }
        textView.setText(h16);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void a() {
        d.a.d(this);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void b(@NotNull qj1.b bottomInteractData) {
        Intrinsics.checkNotNullParameter(bottomInteractData, "bottomInteractData");
        k(bottomInteractData.d());
    }

    @Override // wk1.j
    public void c(@NotNull String action, @Nullable Object msg2) {
        wk1.e c16;
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(action, "action");
        ViewGroup viewGroup2 = null;
        if (Intrinsics.areEqual(action, "message_on_bottom_interact_exposure")) {
            ViewGroup viewGroup3 = this.shareLayout;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareLayout");
                viewGroup3 = null;
            }
            if (viewGroup3.getVisibility() == 0 && (c16 = this.inputContext.c()) != null) {
                ViewGroup viewGroup4 = this.shareLayout;
                if (viewGroup4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shareLayout");
                    viewGroup = null;
                } else {
                    viewGroup = viewGroup4;
                }
                e.a.c(c16, viewGroup, 4, null, 4, null);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(action, "message_on_do_visibility_change") && (msg2 instanceof a.BottomInteractiveVisibilityChangeMessage)) {
            a.BottomInteractiveVisibilityChangeMessage bottomInteractiveVisibilityChangeMessage = (a.BottomInteractiveVisibilityChangeMessage) msg2;
            if (bottomInteractiveVisibilityChangeMessage.getViewType() == 4) {
                ViewGroup viewGroup5 = this.shareLayout;
                if (viewGroup5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shareLayout");
                } else {
                    viewGroup2 = viewGroup5;
                }
                viewGroup2.setVisibility(bottomInteractiveVisibilityChangeMessage.getVisibility());
            }
        }
    }

    @Override // wk1.j
    @Nullable
    public Object d(@NotNull String str, @Nullable Object obj) {
        return d.a.b(this, str, obj);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void e(@NotNull SpeakPermissionType speakPermissionType) {
        d.a.e(this, speakPermissionType);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void init(@NotNull ViewGroup rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        j(rootView);
        h(rootView);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void u1(boolean enable) {
        bl1.d dVar = bl1.d.f28604a;
        ViewGroup viewGroup = this.shareLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareLayout");
            viewGroup = null;
        }
        dVar.a(viewGroup, enable);
    }
}
