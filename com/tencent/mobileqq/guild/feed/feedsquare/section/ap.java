package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSysPromptDigest;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J*\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016J*\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/ap;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedBaseSection;", "Lij1/g;", "data", "", "position", "", ExifInterface.LATITUDE_SOUTH, "type", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "", "", "payload", "M", "L", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvTime", "f", "tvSysPrompt", tl.h.F, "Landroid/view/View;", "itemView", "Landroid/widget/LinearLayout;", "i", "Landroid/widget/LinearLayout;", "llSystemPromptLayout", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ap extends GuildFeedSquareFeedBaseSection {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView tvTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView tvSysPrompt;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View itemView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout llSystemPromptLayout;

    private final void R(int type) {
        Map mapOf;
        View view = this.itemView;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_system_notice_graytext_type", Integer.valueOf(type)));
        ch.T0(view, "em_sgrp_system_notice_graytext", clickPolicy, exposurePolicy, mapOf);
    }

    private final void S(ij1.g data, int position) {
        int b16;
        int b17;
        if (data.r()) {
            b16 = com.tencent.guild.aio.util.c.b(12);
        } else {
            b16 = com.tencent.guild.aio.util.c.b(16);
        }
        if (data.q()) {
            b17 = 0;
        } else {
            b17 = com.tencent.guild.aio.util.c.b(16);
        }
        QLog.d("GuildFeedSquareSystemPromptSection", 1, "data next" + data.q() + ", pre: " + data.r() + " topPadding" + b16 + "  bottomPadding" + b17);
        View view = this.itemView;
        if (view != null) {
            view.setPadding(view.getPaddingLeft(), b16, view.getPaddingRight(), view.getPaddingBottom());
        }
        LinearLayout linearLayout = this.llSystemPromptLayout;
        if (linearLayout != null) {
            linearLayout.setPadding(linearLayout.getPaddingLeft(), linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), b17);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: L */
    public void onBindData(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payload) {
        ij1.g blockData;
        GProSysPromptDigest gProSysPromptDigest;
        super.onBindData(data, position, payload);
        if (data != null && (blockData = data.getBlockData()) != null) {
            Object d16 = blockData.d(blockData.m());
            String str = null;
            if (d16 instanceof GProSysPromptDigest) {
                gProSysPromptDigest = (GProSysPromptDigest) d16;
            } else {
                gProSysPromptDigest = null;
            }
            if (gProSysPromptDigest == null) {
                return;
            }
            S(blockData, position);
            TextView textView = this.tvTime;
            if (textView != null) {
                GProStFeed b16 = data.getBlockData().b();
                if (b16 != null) {
                    str = ax.w(b16.createTime * 1000);
                }
                textView.setText(str);
            }
            TextView textView2 = this.tvSysPrompt;
            if (textView2 != null) {
                textView2.setText(gProSysPromptDigest.contnet);
            }
            R(gProSysPromptDigest.subType);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.wbb};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        TextView textView;
        TextView textView2;
        View view;
        LinearLayout linearLayout = null;
        if (containerView != null) {
            textView = (TextView) containerView.findViewById(R.id.kbp);
        } else {
            textView = null;
        }
        this.tvTime = textView;
        if (containerView != null) {
            textView2 = (TextView) containerView.findViewById(R.id.f111736m1);
        } else {
            textView2 = null;
        }
        this.tvSysPrompt = textView2;
        if (containerView != null) {
            view = containerView.findViewById(R.id.v3b);
        } else {
            view = null;
        }
        this.itemView = view;
        if (containerView != null) {
            linearLayout = (LinearLayout) containerView.findViewById(R.id.yqx);
        }
        this.llSystemPromptLayout = linearLayout;
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection
    public void M(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payload) {
    }
}
