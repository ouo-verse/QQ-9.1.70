package com.tencent.mobileqq.guild.setting.group.groupshow;

import android.content.Context;
import android.view.View;
import az1.GroupChatShowData;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/groupshow/g;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class g {

    /* renamed from: a, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fJ\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/groupshow/g$a;", "", "", "guildId", "Lcom/tencent/qqlive/module/videoreport/PageParams;", "c", "Laz1/c;", "data", "", "b", "Landroid/content/Context;", "context", "Landroid/view/View;", "contentView", "", "a", "view", "d", "i", "f", "", "isExposure", "g", "e", "j", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.group.groupshow.g$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map<String, Object> b(GroupChatShowData data) {
            Map<String, Object> mapOf;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("group_id", String.valueOf(data.getGroupCode())), TuplesKt.to("is_group_member", Boolean.valueOf(data.getIsGroupMember())));
            return mapOf;
        }

        private final PageParams c(String guildId) {
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_channel_id", guildId);
            hashMap.put("sgrp_user_type", Integer.valueOf(v.c(guildId)));
            hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
            return new PageParams(hashMap);
        }

        public static /* synthetic */ void h(Companion companion, View view, boolean z16, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            companion.g(view, z16);
        }

        public final void a(@NotNull Context context, @NotNull View contentView, @NotNull String guildId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(contentView, "contentView");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            VideoReport.addToDetectionWhitelist(KRCSSViewExtensionKt.i(context));
            VideoReport.setPageId(contentView, "pg_sgrp_group_list");
            VideoReport.setPageParams(contentView, c(guildId));
            VideoReport.setPageReportPolicy(contentView, PageReportPolicy.REPORT_ALL);
        }

        public final void d(@NotNull View view, @NotNull GroupChatShowData data) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(data, "data");
            Map<String, ? extends Object> b16 = b(data);
            bt.c(view, "em_sgrp_chat", b16, ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_NONE, EndExposurePolicy.REPORT_NONE);
            bt.f235484a.g(view, "em_sgrp_chat", "clck", b16);
        }

        public final void e(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            bt.h(bt.f235484a, view, "em_sgrp_group_list_manage", "clck", null, 8, null);
        }

        public final void f(@NotNull View view, @NotNull GroupChatShowData data) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(data, "data");
            bt.f235484a.g(view, "em_sgrp_group_list_node", "clck", b(data));
        }

        public final void g(@NotNull View view, boolean isExposure) {
            ExposurePolicy exposurePolicy;
            Intrinsics.checkNotNullParameter(view, "view");
            ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
            if (isExposure) {
                exposurePolicy = ExposurePolicy.REPORT_ALL;
            } else {
                exposurePolicy = ExposurePolicy.REPORT_NONE;
            }
            bt.d(view, "em_sgrp_group_list_manage", null, clickPolicy, exposurePolicy, EndExposurePolicy.REPORT_NONE, 4, null);
        }

        public final void i(@NotNull View view, @NotNull GroupChatShowData data) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(data, "data");
            bt.c(view, "em_sgrp_group_list_node", b(data), ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL, EndExposurePolicy.REPORT_NONE);
        }

        public final void j(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            g(view, true);
        }

        Companion() {
        }
    }
}
