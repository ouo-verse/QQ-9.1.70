package com.tencent.mobileqq.guild.feed.topic.adapter.section;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020\u00058\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/d;", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/b;", "Lvn1/b;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "t", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "r", "()Landroid/widget/ImageView;", "w", "(Landroid/widget/ImageView;)V", "guildAvatar", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", ReportConstant.COSTREPORT_PREFIX, "()Landroid/widget/TextView;", HippyTKDListViewAdapter.X, "(Landroid/widget/TextView;)V", "guildName", "f", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/view/View;", "v", "(Landroid/view/View;)V", ParseCommon.CONTAINER, "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d extends b<vn1.b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public ImageView guildAvatar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public TextView guildName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public View container;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void u(d this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        xn1.e eVar = xn1.e.f448187a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        T mData = this$0.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        eVar.h(it, (vn1.b) mData);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.w_1};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        v(containerView);
        View findViewById = containerView.findViewById(R.id.wrw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.guild_name)");
        x((TextView) findViewById);
        View findViewById2 = containerView.findViewById(R.id.vzu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.guild_avatar)");
        w((ImageView) findViewById2);
        containerView.findViewById(R.id.f100335s8).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.topic.adapter.section.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.u(d.this, view);
            }
        });
    }

    @NotNull
    public final View q() {
        View view = this.container;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
        return null;
    }

    @NotNull
    public final ImageView r() {
        ImageView imageView = this.guildAvatar;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("guildAvatar");
        return null;
    }

    @NotNull
    public final TextView s() {
        TextView textView = this.guildName;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("guildName");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull vn1.b data, int position, @Nullable List<Object> payload) {
        boolean z16;
        Intrinsics.checkNotNullParameter(data, "data");
        String guildName = data.d().getGuildName();
        View q16 = q();
        if (guildName.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Boolean valueOf = Boolean.valueOf(z16);
        q16.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, q16)) == null) {
            q16.setVisibility(8);
        }
        s().setText(guildName);
        com.tencent.mobileqq.guild.picload.e a16 = com.tencent.mobileqq.guild.picload.e.a();
        Option defaultOptions = Option.getDefaultOptions(r());
        defaultOptions.setTargetView(r());
        defaultOptions.setUrl(data.d().getGuildIcon());
        a16.e(defaultOptions);
    }

    public final void v(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.container = view;
    }

    public final void w(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.guildAvatar = imageView;
    }

    public final void x(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.guildName = textView;
    }
}
