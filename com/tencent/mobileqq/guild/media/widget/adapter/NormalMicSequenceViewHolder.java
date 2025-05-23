package com.tencent.mobileqq.guild.media.widget.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.media.widget.GuildMicSequenceDialogFragment;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000 82\u00020\u0001:\u00019B;\u0012\u0006\u00105\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\"\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\u0004\b6\u00107J<\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bH\u0002J\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R3\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010(\u001a\n %*\u0004\u0018\u00010$0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010*\u001a\n %*\u0004\u0018\u00010$0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u001c\u0010,\u001a\n %*\u0004\u0018\u00010$0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010'R\u001c\u0010.\u001a\n %*\u0004\u0018\u00010 0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010\"R\u001c\u00100\u001a\n %*\u0004\u0018\u00010 0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010\"R\u001c\u00104\u001a\n %*\u0004\u0018\u000101018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/adapter/NormalMicSequenceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "reportView", "", "elementId", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "param", "", "p", "Lcom/tencent/mobileqq/guild/media/widget/adapter/e;", "data", "guildId", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/media/widget/GuildMicSequenceDialogFragment;", "E", "Lcom/tencent/mobileqq/guild/media/widget/GuildMicSequenceDialogFragment;", "o", "()Lcom/tencent/mobileqq/guild/media/widget/GuildMicSequenceDialogFragment;", "fragment", UserInfo.SEX_FEMALE, "Ljava/util/HashMap;", "getMPageParam", "()Ljava/util/HashMap;", "mPageParam", "G", "Ljava/lang/String;", "mTinyId", "H", "mNickName", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "mSeqTextView", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "J", "Landroid/view/ViewGroup;", "mCtrlButtonArea", "K", "mDeleteBtn", "L", "mSetTopBtn", "M", "mUserNameTv", "N", "mTitle", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "P", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "headView", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/guild/media/widget/GuildMicSequenceDialogFragment;Ljava/util/HashMap;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
final class NormalMicSequenceViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final GuildMicSequenceDialogFragment fragment;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, Object> mPageParam;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String mTinyId;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String mNickName;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final TextView mSeqTextView;

    /* renamed from: J, reason: from kotlin metadata */
    private final ViewGroup mCtrlButtonArea;

    /* renamed from: K, reason: from kotlin metadata */
    private final ViewGroup mDeleteBtn;

    /* renamed from: L, reason: from kotlin metadata */
    private final ViewGroup mSetTopBtn;

    /* renamed from: M, reason: from kotlin metadata */
    private final TextView mUserNameTv;

    /* renamed from: N, reason: from kotlin metadata */
    private final TextView mTitle;

    /* renamed from: P, reason: from kotlin metadata */
    private final GuildUserAvatarView headView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NormalMicSequenceViewHolder(@NotNull View itemView, @NotNull GuildMicSequenceDialogFragment fragment, @NotNull HashMap<String, Object> mPageParam) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(mPageParam, "mPageParam");
        this.fragment = fragment;
        this.mPageParam = mPageParam;
        this.mTinyId = "";
        this.mNickName = "";
        View findViewById = itemView.findViewById(R.id.f83334j_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.sequence_text)");
        this.mSeqTextView = (TextView) findViewById;
        this.mCtrlButtonArea = (ViewGroup) itemView.findViewById(R.id.f74563wl);
        final ViewGroup mDeleteBtn$lambda$0 = (ViewGroup) itemView.findViewById(R.id.bfq);
        Intrinsics.checkNotNullExpressionValue(mDeleteBtn$lambda$0, "mDeleteBtn$lambda$0");
        jt1.b.b(mDeleteBtn$lambda$0, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.adapter.NormalMicSequenceViewHolder$mDeleteBtn$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                String str;
                Intrinsics.checkNotNullParameter(it, "it");
                GuildMicSequenceDialogFragment fragment2 = NormalMicSequenceViewHolder.this.getFragment();
                str = NormalMicSequenceViewHolder.this.mTinyId;
                fragment2.Bh(Long.parseLong(str));
                NormalMicSequenceViewHolder normalMicSequenceViewHolder = NormalMicSequenceViewHolder.this;
                ViewGroup viewGroup = mDeleteBtn$lambda$0;
                Intrinsics.checkNotNullExpressionValue(viewGroup, "this");
                normalMicSequenceViewHolder.p(viewGroup, "em_sgrp_queuemanage_delete", new HashMap());
            }
        });
        this.mDeleteBtn = mDeleteBtn$lambda$0;
        final ViewGroup mSetTopBtn$lambda$1 = (ViewGroup) itemView.findViewById(R.id.f83654k5);
        Intrinsics.checkNotNullExpressionValue(mSetTopBtn$lambda$1, "mSetTopBtn$lambda$1");
        jt1.b.b(mSetTopBtn$lambda$1, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.adapter.NormalMicSequenceViewHolder$mSetTopBtn$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                String str;
                Intrinsics.checkNotNullParameter(it, "it");
                GuildMicSequenceDialogFragment fragment2 = NormalMicSequenceViewHolder.this.getFragment();
                str = NormalMicSequenceViewHolder.this.mTinyId;
                fragment2.Yh(Long.parseLong(str));
                NormalMicSequenceViewHolder normalMicSequenceViewHolder = NormalMicSequenceViewHolder.this;
                ViewGroup viewGroup = mSetTopBtn$lambda$1;
                Intrinsics.checkNotNullExpressionValue(viewGroup, "this");
                normalMicSequenceViewHolder.p(viewGroup, "em_sgrp_queuemanage_top", new HashMap());
            }
        });
        this.mSetTopBtn = mSetTopBtn$lambda$1;
        this.mUserNameTv = (TextView) itemView.findViewById(R.id.f114996uu);
        this.mTitle = (TextView) itemView.findViewById(R.id.title);
        GuildUserAvatarView headView$lambda$2 = (GuildUserAvatarView) itemView.findViewById(R.id.x87);
        Intrinsics.checkNotNullExpressionValue(headView$lambda$2, "headView$lambda$2");
        jt1.b.b(headView$lambda$2, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.adapter.NormalMicSequenceViewHolder$headView$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                String str;
                Intrinsics.checkNotNullParameter(it, "it");
                GuildMicSequenceDialogFragment fragment2 = NormalMicSequenceViewHolder.this.getFragment();
                str = NormalMicSequenceViewHolder.this.mTinyId;
                fragment2.Kh(str);
            }
        });
        this.headView = headView$lambda$2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(View reportView, String elementId, HashMap<String, Object> param) {
        Map plus;
        this.mPageParam.put("sgrp_user_id", this.mTinyId);
        VideoReport.setElementId(reportView, elementId);
        VideoReport.setElementExposePolicy(reportView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(reportView, ClickPolicy.REPORT_NONE);
        plus = MapsKt__MapsKt.plus(param, this.mPageParam);
        VideoReport.reportEvent("clck", reportView, plus);
    }

    public final void n(@NotNull MicSequenceData data, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.mSeqTextView.setText(String.valueOf(data.getSeq()));
        if (data.getSeq() == 2) {
            this.mSetTopBtn.setVisibility(8);
        } else {
            this.mSetTopBtn.setVisibility(0);
        }
        this.mTinyId = data.getTinyId();
        String nickName = data.getNickName();
        this.mNickName = nickName;
        this.mUserNameTv.setText(nickName);
        this.headView.setAvatarTinyId(guildId, data.getTinyId());
        if (!this.fragment.getMIsManager()) {
            this.mCtrlButtonArea.setVisibility(8);
        } else {
            this.mCtrlButtonArea.setVisibility(0);
        }
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final GuildMicSequenceDialogFragment getFragment() {
        return this.fragment;
    }
}
