package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendRobotData;
import com.tencent.mobileqq.guild.discoveryv2.widget.GuildAsyncRichTextView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.statustitle.OnPostThemeChanged;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0014J(\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0014J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u0012\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\u001e\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001c0\u001bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001c`\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010&R\u0018\u00100\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ap;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ar;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendRobotData;", "Lcom/tencent/guild/aio/util/ex/c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", ReportConstant.COSTREPORT_PREFIX, "initListener", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "t", "v", "", NodeProps.ON_LONG_CLICK, NodeProps.ON_CLICK, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "background", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "name", "Lcom/tencent/mobileqq/guild/discoveryv2/widget/GuildAsyncRichTextView;", tl.h.F, "Lcom/tencent/mobileqq/guild/discoveryv2/widget/GuildAsyncRichTextView;", "desc", "i", "button", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "gradientMask", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ap extends ar<RecommendRobotData> implements com.tencent.guild.aio.util.ex.c, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView background;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView name;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildAsyncRichTextView desc;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView button;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View gradientMask;

    private final void initListener() {
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewExtKt.b(rootView, this);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private final void s() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        int color = ContextCompat.getColor(this.mRootView.getContext(), R.color.qui_common_bg_middle_light);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
        gradientDrawable.setColors(new int[]{color, 0});
        View view = this.gradientMask;
        if (view != null) {
            view.setBackgroundDrawable(gradientDrawable);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(OnPostThemeChanged.class);
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        com.tencent.mobileqq.guild.discoveryv2.content.recommend.d p16 = p();
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        p16.k((RecommendRobotData) mData, v3);
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.background = (ImageView) containerView.findViewById(R.id.f165479w74);
        this.name = (TextView) containerView.findViewById(R.id.w78);
        this.desc = (GuildAsyncRichTextView) containerView.findViewById(R.id.w76);
        this.button = (TextView) containerView.findViewById(R.id.w75);
        this.gradientMask = containerView.findViewById(R.id.w77);
        s();
        initListener();
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(@NotNull View v3) {
        EventCollector.getInstance().onViewLongClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        com.tencent.mobileqq.guild.discoveryv2.content.recommend.d p16 = p();
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        boolean i3 = p16.i((com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l) mData, v3, this.mPosition);
        EventCollector.getInstance().onViewLongClicked(v3);
        return i3;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof OnPostThemeChanged) {
            s();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull RecommendRobotData data, int position, @Nullable List<Object> payload) {
        TextView textView;
        GuildAsyncRichTextView guildAsyncRichTextView;
        TextView textView2;
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getPicInfo() != null) {
            ImageView imageView = this.background;
            if (imageView != null) {
                layoutParams = imageView.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.height = q().b();
            }
            ImageView imageView2 = this.background;
            if (imageView2 != null) {
                imageView2.setLayoutParams(layoutParams);
            }
            ImageView imageView3 = this.background;
            if (imageView3 != null) {
                com.tencent.mobileqq.guild.discoveryv2.util.d.c(com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a, imageView3, data.getPicInfo().getPicUrl(), q().b(), q().b(), false, 16, null);
            }
        }
        String nickName = data.getNickName();
        if (nickName != null && (textView2 = this.name) != null) {
            textView2.setText(nickName);
        }
        String desc = data.getDesc();
        if (desc != null && (guildAsyncRichTextView = this.desc) != null) {
            guildAsyncRichTextView.setText(desc);
        }
        String buttonName = data.getButtonName();
        if (buttonName != null && (textView = this.button) != null) {
            textView.setText(buttonName);
        }
        QLog.i("RecommendRobotSection", 1, "onBindData, data=" + data);
    }
}
