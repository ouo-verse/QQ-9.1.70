package com.tencent.mobileqq.guild.feed.gallery.comment.part;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.event.GuildFeedExternalCommentsUpdatedEvent;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl1.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u00015\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001>B\u0011\u0012\b\u0010:\u001a\u0004\u0018\u000109\u00a2\u0006\u0004\b;\u0010<J\u001e\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0002J \u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\u0012\u0010\u001f\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u001c\u0010\"\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010$\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u000bH\u0016R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/s;", "Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/a;", "Landroid/view/View$OnClickListener;", "", "rankType", "", "", "", "F9", "", "E9", "Landroid/view/View;", "contentView", "I9", "J9", "message", "H9", "changedSource", "feedId", "commentCount", "G9", WidgetCacheConstellationData.NUM, "L9", "type", "K9", "from", "M9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "action", "args", "handleBroadcastMessage", "v", NodeProps.ON_CLICK, "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "commentTv", "Landroid/widget/RadioGroup;", tl.h.F, "Landroid/widget/RadioGroup;", "rankingContainer", "Landroid/widget/RadioButton;", "i", "Landroid/widget/RadioButton;", "rankingTypeDefaultRB", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "rankingTypeNewRB", BdhLogUtil.LogTag.Tag_Conn, "I", "com/tencent/mobileqq/guild/feed/gallery/comment/part/s$b", "D", "Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/s$b;", "commonTitleIoc", "Lgk1/b;", "contextProvider", "<init>", "(Lgk1/b;)V", "E", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class s extends a implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private int rankType;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b commonTitleIoc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView commentTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RadioGroup rankingContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RadioButton rankingTypeDefaultRB;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RadioButton rankingTypeNewRB;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/comment/part/s$b", "Lvl1/b;", "", "y0", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements vl1.b {
        b() {
        }

        @Override // vl1.b
        /* renamed from: y0 */
        public int getRankingType() {
            return s.this.rankType;
        }
    }

    public s(@Nullable gk1.b bVar) {
        super(bVar);
        this.rankType = 1;
        this.commonTitleIoc = new b();
    }

    private final void E9() {
        RadioGroup radioGroup = this.rankingContainer;
        if (radioGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankingContainer");
            radioGroup = null;
        }
        com.tencent.mobileqq.guild.feed.report.d.e(radioGroup, "em_sgrp_forum_sort", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_ALL, EndExposurePolicy.REPORT_NONE, F9(1), null);
    }

    private final Map<String, Object> F9(int rankType) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sgrp_sort_type", Integer.valueOf(rankType));
        return linkedHashMap;
    }

    private final void G9(int changedSource, String feedId, int commentCount) {
        gk1.b contextProvide;
        wk1.i a16;
        QLog.d("Guild_Feed_GAL_GuildFeedGalleryCommentTitlePart", 1, "[handleCommentChanged] commentCount=" + commentCount);
        if ((changedSource == 6 || changedSource == 10 || changedSource == 13) && (contextProvide = getContextProvide()) != null && (a16 = contextProvide.a()) != null) {
            a16.lh("message_on_comment_content_change", new GuildFeedExternalCommentsUpdatedEvent(feedId, commentCount));
        }
    }

    private final void H9(Object message) {
        gk1.b contextProvide;
        wk1.i a16;
        if (!(message instanceof g.OnDataListChangedMessage)) {
            return;
        }
        g.OnDataListChangedMessage onDataListChangedMessage = (g.OnDataListChangedMessage) message;
        List<hl1.g> b16 = onDataListChangedMessage.b();
        ArrayList arrayList = new ArrayList();
        for (Object obj : b16) {
            if (obj instanceof jl1.f) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        int i3 = 0;
        jl1.f fVar = (jl1.f) arrayList.get(0);
        if (fVar.getTotalNum() > 0) {
            i3 = fVar.getTotalNum();
        }
        L9(i3);
        K9(this.rankType);
        if ((onDataListChangedMessage.getChangedSource() == 6 || onDataListChangedMessage.getChangedSource() == 10 || onDataListChangedMessage.getChangedSource() == 2 || onDataListChangedMessage.getChangedSource() == 4 || onDataListChangedMessage.getChangedSource() == 14) && (contextProvide = getContextProvide()) != null && (a16 = contextProvide.a()) != null) {
            a.ModifyBottomInteractiveDataMessage modifyBottomInteractiveDataMessage = new a.ModifyBottomInteractiveDataMessage(null, true, null, null, null, null, 61, null);
            modifyBottomInteractiveDataMessage.h(z9().getFeedId());
            modifyBottomInteractiveDataMessage.g(Integer.valueOf(i3));
            Unit unit = Unit.INSTANCE;
            a16.lh("message_modify_bottom_interact_data", modifyBottomInteractiveDataMessage);
        }
        G9(onDataListChangedMessage.getChangedSource(), z9().getFeedId(), i3);
    }

    private final void I9(View contentView) {
        ViewGroup initTitleView$lambda$2 = (ViewGroup) contentView.findViewById(R.id.w8o);
        ViewGroup.LayoutParams layoutParams = initTitleView$lambda$2.getLayoutParams();
        if (layoutParams != null) {
            Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams");
            layoutParams.height = ViewUtils.dpToPx(50.0f);
            initTitleView$lambda$2.setLayoutParams(layoutParams);
        }
        Intrinsics.checkNotNullExpressionValue(initTitleView$lambda$2, "initTitleView$lambda$2");
        ViewExtKt.c(initTitleView$lambda$2, ViewUtils.dpToPx(20.0f));
        View findViewById = contentView.findViewById(R.id.w8p);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById\u2026d_feed_detail_comment_tv)");
        this.commentTv = (TextView) findViewById;
        L9(z9().getCommentCount());
        View findViewById2 = contentView.findViewById(R.id.w8v);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById\u2026ed_detail_sort_container)");
        this.rankingContainer = (RadioGroup) findViewById2;
        View findViewById3 = contentView.findViewById(R.id.f165630x14);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentView.findViewById(R.id.guild_sort_default)");
        this.rankingTypeDefaultRB = (RadioButton) findViewById3;
        View findViewById4 = contentView.findViewById(R.id.f165631x15);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "contentView.findViewById(R.id.guild_sort_new)");
        this.rankingTypeNewRB = (RadioButton) findViewById4;
        RadioGroup radioGroup = this.rankingContainer;
        if (radioGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankingContainer");
            radioGroup = null;
        }
        radioGroup.setVisibility(8);
        J9();
    }

    private final void J9() {
        RadioButton radioButton = this.rankingTypeDefaultRB;
        RadioButton radioButton2 = null;
        if (radioButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankingTypeDefaultRB");
            radioButton = null;
        }
        radioButton.setOnClickListener(this);
        RadioButton radioButton3 = this.rankingTypeNewRB;
        if (radioButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankingTypeNewRB");
        } else {
            radioButton2 = radioButton3;
        }
        radioButton2.setOnClickListener(this);
    }

    private final void K9(int type) {
        RadioButton radioButton = null;
        if (type != 1) {
            if (type == 2) {
                RadioButton radioButton2 = this.rankingTypeNewRB;
                if (radioButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rankingTypeNewRB");
                } else {
                    radioButton = radioButton2;
                }
                radioButton.setChecked(true);
                return;
            }
            return;
        }
        RadioButton radioButton3 = this.rankingTypeDefaultRB;
        if (radioButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankingTypeDefaultRB");
        } else {
            radioButton = radioButton3;
        }
        radioButton.setChecked(true);
    }

    private final void L9(int num) {
        TextView textView = this.commentTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentTv");
            textView = null;
        }
        textView.setText("\u8bc4\u8bba " + bl1.b.h(bl1.b.f28597a, num, null, null, 6, null));
    }

    private final void M9(int type, String from) {
        QLog.d("Guild_Feed_GAL_GuildFeedGalleryCommentTitlePart", 1, "updateRankingType type:" + type + ", from:" + from);
        if (type == this.rankType) {
            return;
        }
        this.rankType = type;
        broadcastMessage("message_reload", new g.ReloadMessage("CommentTitlePart", 2, new g.ReloadCommentDataMessage(type, from)));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "message_data_list_changed")) {
            H9(args);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        RadioGroup radioGroup = null;
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.f165630x14) {
            if (!com.tencent.mobileqq.guild.util.o.a(v3)) {
                M9(1, "DetailCommentTitleSection");
                RadioGroup radioGroup2 = this.rankingContainer;
                if (radioGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rankingContainer");
                } else {
                    radioGroup = radioGroup2;
                }
                VideoReport.reportEvent("dt_clck", radioGroup, F9(1));
            }
        } else if (num != null && num.intValue() == R.id.f165631x15 && !com.tencent.mobileqq.guild.util.o.a(v3)) {
            M9(2, "DetailCommentTitleSection");
            RadioGroup radioGroup3 = this.rankingContainer;
            if (radioGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rankingContainer");
            } else {
                radioGroup = radioGroup3;
            }
            VideoReport.reportEvent("dt_clck", radioGroup, F9(2));
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        I9(rootView);
        E9();
        RFWIocAbilityProvider.g().registerIoc(rootView, this.commonTitleIoc, vl1.b.class);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), vl1.b.class);
    }
}
