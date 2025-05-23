package com.tencent.mobileqq.guild.media.widget.adapter;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.data.r;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.notify.y;
import com.tencent.mobileqq.guild.media.widget.GuildMicSequenceDialogFragment;
import com.tencent.mobileqq.guild.media.widget.GuildWavAvatarImageView;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0001>\b\u0002\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010B\u001a\u00020\u000f\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\"\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\u0012j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0013`\u0014\u00a2\u0006\u0004\bC\u0010DJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J<\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00072\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\u0012j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0013`\u0014H\u0002J\u0016\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u001a\u001a\u00020\u0005R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR3\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\u0012j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0013`\u00148\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u001c\u00105\u001a\n 2*\u0004\u0018\u000101018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001c\u00107\u001a\n 2*\u0004\u0018\u000101018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00104R\u001c\u00109\u001a\n 2*\u0004\u0018\u00010+0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010-R\u001c\u0010=\u001a\n 2*\u0004\u0018\u00010:0:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/adapter/TopOnMicViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "userList", "", HippyTKDListViewAdapter.X, "", "guildId", "channelId", "", "u", "", "gender", "w", "Landroid/view/View;", "reportView", "elementId", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "param", "v", "Lcom/tencent/mobileqq/guild/media/widget/adapter/e;", "data", "r", "resetStatusAndAnim", "Lcom/tencent/mobileqq/guild/media/widget/GuildMicSequenceDialogFragment;", "E", "Lcom/tencent/mobileqq/guild/media/widget/GuildMicSequenceDialogFragment;", "t", "()Lcom/tencent/mobileqq/guild/media/widget/GuildMicSequenceDialogFragment;", "fragment", UserInfo.SEX_FEMALE, "Ljava/util/HashMap;", "getMPageParam", "()Ljava/util/HashMap;", "mPageParam", "G", "Ljava/lang/String;", "mTinyId", "H", "mNickName", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "mCountDownTimeTv", "J", "mSeqTextView", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "K", "Landroid/view/ViewGroup;", "mCtrlButtonArea", "L", "mDeleteBtn", "M", "mUserNameTv", "Lcom/tencent/mobileqq/guild/media/widget/GuildWavAvatarImageView;", "N", "Lcom/tencent/mobileqq/guild/media/widget/GuildWavAvatarImageView;", "headView", "com/tencent/mobileqq/guild/media/widget/adapter/TopOnMicViewHolder$a", "P", "Lcom/tencent/mobileqq/guild/media/widget/adapter/TopOnMicViewHolder$a;", "mediaObserver", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/guild/media/widget/GuildMicSequenceDialogFragment;Ljava/util/HashMap;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class TopOnMicViewHolder extends RecyclerView.ViewHolder {

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
    private TextView mCountDownTimeTv;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private TextView mSeqTextView;

    /* renamed from: K, reason: from kotlin metadata */
    private final ViewGroup mCtrlButtonArea;

    /* renamed from: L, reason: from kotlin metadata */
    private final ViewGroup mDeleteBtn;

    /* renamed from: M, reason: from kotlin metadata */
    private final TextView mUserNameTv;

    /* renamed from: N, reason: from kotlin metadata */
    private final GuildWavAvatarImageView headView;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final a mediaObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/media/widget/adapter/TopOnMicViewHolder$a", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "", "guildId", "channelId", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "localUserInfo", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "userInfoList", "", "w", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends y {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void w(@NotNull String guildId, @NotNull String channelId, @Nullable com.tencent.mobileqq.guild.media.core.data.f localUserInfo, @Nullable r userInfoList) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            if (TopOnMicViewHolder.this.u(guildId, channelId) && userInfoList != null && !userInfoList.f228125a.isEmpty()) {
                TopOnMicViewHolder topOnMicViewHolder = TopOnMicViewHolder.this;
                List<p> list = userInfoList.f228125a;
                Intrinsics.checkNotNullExpressionValue(list, "userInfoList.anchors");
                topOnMicViewHolder.x(list);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopOnMicViewHolder(@NotNull View itemView, @NotNull GuildMicSequenceDialogFragment fragment, @NotNull HashMap<String, Object> mPageParam) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(mPageParam, "mPageParam");
        this.fragment = fragment;
        this.mPageParam = mPageParam;
        this.mTinyId = "";
        this.mNickName = "";
        View findViewById = itemView.findViewById(R.id.f115126v7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.userTime)");
        this.mCountDownTimeTv = (TextView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.f83334j_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.sequence_text)");
        this.mSeqTextView = (TextView) findViewById2;
        this.mCtrlButtonArea = (ViewGroup) itemView.findViewById(R.id.f74563wl);
        ViewGroup mDeleteBtn$lambda$0 = (ViewGroup) itemView.findViewById(R.id.bfq);
        Intrinsics.checkNotNullExpressionValue(mDeleteBtn$lambda$0, "mDeleteBtn$lambda$0");
        jt1.b.b(mDeleteBtn$lambda$0, new TopOnMicViewHolder$mDeleteBtn$1$1(this, mDeleteBtn$lambda$0));
        this.mDeleteBtn = mDeleteBtn$lambda$0;
        this.mUserNameTv = (TextView) itemView.findViewById(R.id.f114996uu);
        GuildWavAvatarImageView headView$lambda$1 = (GuildWavAvatarImageView) itemView.findViewById(R.id.x87);
        Intrinsics.checkNotNullExpressionValue(headView$lambda$1, "headView$lambda$1");
        jt1.b.b(headView$lambda$1, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.adapter.TopOnMicViewHolder$headView$1$1
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
                GuildMicSequenceDialogFragment fragment2 = TopOnMicViewHolder.this.getFragment();
                str = TopOnMicViewHolder.this.mTinyId;
                fragment2.Kh(str);
            }
        });
        this.headView = headView$lambda$1;
        this.mediaObserver = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean u(String guildId, String channelId) {
        com.tencent.mobileqq.guild.media.core.e a16 = j.a();
        if (Intrinsics.areEqual(guildId, a16.getGuildID()) && Intrinsics.areEqual(channelId, a16.E())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(View reportView, String elementId, HashMap<String, Object> param) {
        Map plus;
        this.mPageParam.put("sgrp_user_id", this.mTinyId);
        VideoReport.setElementId(reportView, elementId);
        VideoReport.setElementExposePolicy(reportView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(reportView, ClickPolicy.REPORT_NONE);
        plus = MapsKt__MapsKt.plus(param, this.mPageParam);
        VideoReport.reportEvent("clck", reportView, plus);
    }

    private final void w(int gender) {
        if (gender == 2) {
            this.headView.setColor(Color.parseColor("#FF4FA7"));
        } else {
            this.headView.setColor(Color.parseColor("#00B3FF"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(List<p> userList) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : userList) {
            if (Intrinsics.areEqual(((p) obj).f228093a, this.mTinyId)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            int i3 = ((p) arrayList.get(0)).f228109q;
            if (i3 > 0) {
                this.headView.setVolume(i3);
            } else {
                this.headView.z();
            }
        }
    }

    public final void r(@NotNull MicSequenceData data, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.mSeqTextView.setText(String.valueOf(data.getSeq()));
        this.mTinyId = data.getTinyId();
        String nickName = data.getNickName();
        this.mNickName = nickName;
        this.mUserNameTv.setText(nickName);
        this.headView.setAvatarTinyId(guildId, data.getTinyId(), data.getAvatarMeta(), "");
        if (!this.fragment.getMIsManager()) {
            this.mCtrlButtonArea.setVisibility(8);
        } else {
            this.mCtrlButtonArea.setVisibility(0);
        }
        w(data.getGender());
        MutableLiveData<Integer> l06 = j.a().M().l0();
        GuildMicSequenceDialogFragment guildMicSequenceDialogFragment = this.fragment;
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.adapter.TopOnMicViewHolder$bindData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer currentCountDownTime) {
                TextView textView;
                if (currentCountDownTime != null && currentCountDownTime.intValue() == 0) {
                    return;
                }
                textView = TopOnMicViewHolder.this.mCountDownTimeTv;
                MediaChannelUtils mediaChannelUtils = MediaChannelUtils.f228046a;
                Intrinsics.checkNotNullExpressionValue(currentCountDownTime, "currentCountDownTime");
                textView.setText(mediaChannelUtils.f(Math.abs(currentCountDownTime.intValue())));
            }
        };
        l06.observe(guildMicSequenceDialogFragment, new Observer() { // from class: com.tencent.mobileqq.guild.media.widget.adapter.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopOnMicViewHolder.s(Function1.this, obj);
            }
        });
        j.a().l0().b(this.mediaObserver);
    }

    public final void resetStatusAndAnim() {
        this.headView.A();
        j.a().l0().B(this.mediaObserver);
    }

    @NotNull
    /* renamed from: t, reason: from getter */
    public final GuildMicSequenceDialogFragment getFragment() {
        return this.fragment;
    }
}
